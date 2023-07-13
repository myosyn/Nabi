package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.edit
import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.MemberData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import live.shuuyu.nabi.kord.utils.ColorUtils
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.seconds

// TODO: If the date is greater than 28 days, revert to the legacy mute option as it allows for a larger date to be stored.
class MuteExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to timeout.")
        val duration = string("duration", "The amount of time you want to timeout the user for.")
        val reason = optionalString("reason", "The reason why this user was timed out")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."
        val muteDuration = Duration.parse(args[options.duration])
        val guild = Guild(
            GuildData.from(rest.guild.getGuild(context.guildId)),
            kord
        )

        if (validateMute(context, args, guild, context.sender))
            return timeoutUser(
                MuteData(context.member.memberData, target.data, reason, muteDuration, context.sender),
                context
            )
    }

    private suspend fun timeoutUser(data: MuteData, context: GuildApplicationCommandContext) {
        val member = Member(data.member, data.user, kord)

        member.edit {
            communicationDisabledUntil = Clock.System.now().plus(data.timeoutDuration)
            reason = data.reason
        }

        context.sendMessage {
            createMuteConfirmationEmbed(
                User(data.user, kord),
                Guild(GuildData.from(rest.guild.getGuild(context.guildId)), kord),
                data.reason,
                data.moderator
            )
        }
    }

    private suspend fun validateMute(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        moderator: User,
    ): Boolean {
        val target = args[options.user]
        val duration = Duration.parse(args[options.duration])

        when {
            Permission.ModerateMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "**I'm currently missing the `MODERATE_MEMBERS` permission!**"
                }
                return false
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "**I'm not allowed to timeout bots!**"
                }
                return false
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {
                    content = "**I am not allowed to timeout the owner!**"
                }
                return false
            }

            target.id == moderator.id -> {
                context.sendEphemeralMessage {
                    content = "**You're not allowed to timeout yourself!**"
                }
                return false
            }

            duration > 28.days -> {
                context.sendEphemeralMessage {
                    content = "**Timeouts cannot exceed 28 days due to a Discord limitation.**"
                }
                return false
            }

            duration < 1.seconds -> {
                context.sendEphemeralMessage {
                    content = "**Timeouts cannot be smaller than 1 second."
                }
                return false
            }

            else -> return true
        }
    }

    private fun InteractionOrFollowupMessageCreateBuilder.createMuteConfirmationEmbed(
        user: User,
        guild: Guild,
        reason: String,
        moderator: User
    ) {
        embed {
            title = "**${user.username}** muted"
            description = "${user.mention} has been muted in **${guild.name}** for **$reason** \n" +
                    "**Moderator:** ${moderator.mention}"
            color = ColorUtils.SUCCESS_COLOR
            timestamp = Clock.System.now()
        }
    }

    private class MuteData(
        val member: MemberData,
        val user: UserData,
        val reason: String,
        val timeoutDuration: Duration,
        val moderator: User
    )
}

class MuteDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("mute", "Mutes the specified user.") {
        defaultMemberPermissions = Permissions {
            +Permission.ModerateMembers
        }

        dmPermission = false

        executor = MuteExecutor(nabi)
    }
}