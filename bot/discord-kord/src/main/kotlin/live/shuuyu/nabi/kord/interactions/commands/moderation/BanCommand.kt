package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.common.serialization.DurationInDays
import dev.kord.core.behavior.ban
import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import live.shuuyu.nabi.kord.utils.ColorUtils
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration.Companion.days

class BanExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why this user is being banned.")
        val messageDurationInt = optionalInteger(
            "delete_message_days",
            "The days worth of messages you want to delete. This option can be between 0 and 7."
        ) {
            mapOf(
                "0 days" to 0,
                "1 day" to 1,
                "2 days" to 2,
                "3 days" to 3,
                "4 days" to 4,
                "5 days" to 5,
                "6 days" to 6,
                "7 days" to 7
            ).forEach { (days, int) ->
                choice(days, int.toLong())
            }

            minValue = 0
            maxValue = 7
        }
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val banReason = args[options.reason] ?: "No reason provided"
        val deleteMessageInteger = args[options.messageDurationInt] ?: 7
        val guildData = GuildData.from(rest.guild.getGuild(context.guildId))

        if (validateBan(context, args, Guild(guildData, kord), context.sender))
            return banUser(
                BanData(guildData, target.data, banReason, deleteMessageInteger.days, context.sender),
                context
            )
    }

    private suspend fun banUser(data: BanData, context: GuildApplicationCommandContext) {
        val guild = Guild(data.guild, kord)
        val user = User(data.user, kord)

        guild.ban(user.id) {
            reason = data.reason
            deleteMessageDuration = data.deleteMessageDays
        }

        context.sendMessage {
            banConfirmationEmbed(user, guild, data.reason, data.moderator)
        }
    }

    private suspend fun validateBan(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        moderator: User
    ): Boolean {
        val target = args[options.user]

        when {
            Permission.BanMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "**I'm currently missing the `BAN_MEMBERS` permission!**"
                }
                return false
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "**I'm not allowed to ban other bots!**"
                }
                return false
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {
                    content = "**You're not allowed to ban the owner!**"
                }
                return false
            }

            target.id == moderator.id -> {
                context.sendEphemeralMessage {
                    content = "**You cannot ban yourself!**"
                }
                return false
            }

            else -> return true
        }
    }

    private fun InteractionOrFollowupMessageCreateBuilder.banConfirmationEmbed(
        user: User,
        guild: Guild,
        reason: String,
        moderator: User
    ) {
        embed {
            title = "${user.username} Banned"
            image = (user.avatar ?: user.defaultAvatar).cdnUrl.toUrl()
            description = "${user.username} has been banned from ${guild.name} for **$reason**" +
                    "**Moderator: ${moderator.mention}"
            color = ColorUtils.SUCCESS_COLOR
            timestamp = Clock.System.now()
        }
    }

    private class BanData(
        val guild: GuildData,
        val user: UserData,
        val reason: String,
        val deleteMessageDays: DurationInDays,
        val moderator: User
    )
}

class BanDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("ban", "Bans a user from the current guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.BanMembers
        }

        // Why would you ban from your dms?
        dmPermission = false

        executor = BanExecutor(nabi)
    }
}