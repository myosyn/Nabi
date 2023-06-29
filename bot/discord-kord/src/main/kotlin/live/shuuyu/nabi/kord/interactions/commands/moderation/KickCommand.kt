package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
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

        val user = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."

        val guild = Guild(GuildData.from(rest.guild.getGuild(context.guildId)), kord)

        kickUser(guild, user, reason)
    }

    private suspend fun kickUser(
        guild: Guild,
        user: User,
        reason: String?
    ) {
        guild.kick(user.id, reason)
    }

    private suspend fun checkPermissions(
        context: ApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        user: User
    ){
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]

        when {
            Permission.KickMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "I'm currently missing the `KICK_MEMBERS` permission!"
                }
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "I'm not allowed to ban other bots!"
                }
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {
                    content = "You're not allowed to ban the owner!"
                }
            }

            target.id == user.id -> {
                context.sendEphemeralMessage {
                    content = "You're not allowed to kick yourself!"
                }
            }

            else -> return
        }
    }
}

class KickDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks the requested user out of the guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.KickMembers
        }

        executor = KickExecutor(nabi)
    }

}