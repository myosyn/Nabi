package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
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

class KickExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to kick from the server.")
        val reason = optionalString("reason", "The reason why this user is being kicked.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."

        val guildData = GuildData.from(rest.guild.getGuild(context.guildId))

        if (validateKick(context, args, Guild(guildData, kord), context.sender))
            return kickUser(KickData(guildData, target.data, reason, context.sender), context)
    }

    private suspend fun kickUser(data: KickData, context: ApplicationCommandContext) {
        val guild = Guild(data.guild, kord)
        val user = User(data.user, kord)

        guild.kick(user.id, data.reason)

        context.sendMessage {
            createKickConfirmationEmbed(user, guild, data.reason, data.moderator)
        }
    }

    private suspend fun validateKick(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        moderator: User
    ): Boolean {

        val target = args[options.user]

        when {
            Permission.KickMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "**I'm currently missing the `KICK_MEMBERS` permission!**"
                }
                return false
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "**I'm not allowed to kick other bots!**"
                }
                return false
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {
                    content = "**You're not allowed to kick the owner!**"
                }
                return false
            }

            target.id == moderator.id -> {
                context.sendEphemeralMessage {
                    content = "**You're not allowed to kick yourself!**"
                }
                return false
            }

            else -> return true
        }
    }

    private fun InteractionOrFollowupMessageCreateBuilder.createKickConfirmationEmbed(
        user: User,
        guild: Guild,
        reason: String,
        moderator: User,
    ) {
        embed {
            title = "${user.username} Kicked"
            description = "**${user.username}** was kicked from **${guild.name}** for **$reason** \n" +
                "**Moderator:** ${moderator.mention}"
            color = ColorUtils.SUCCESS_COLOR
            timestamp = Clock.System.now()
        }
    }

    private class KickData(
        val guild: GuildData,
        val user: UserData,
        val reason: String,
        val moderator: User
    )
}

class KickDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks the requested user out of the guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.KickMembers
        }

        dmPermission = false

        executor = KickExecutor(nabi)
    }
}