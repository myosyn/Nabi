package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.ban
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

class BanExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why this user is being banned.")
        val messageDurationInt = optionalInteger("deleteMessageDays", "The days worth of messages you want to delete.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val banReason = args[options.reason] ?: "No reason provided"
        val thisIntegerlol = args[options.messageDurationInt] ?: 7

        val guild = Guild(GuildData.from(rest.guild.getGuild(context.guildId)), kord)

        banUser(guild, target, banReason, thisIntegerlol.days)
    }

    private suspend fun banUser(
        guild: Guild,
        user: User,
        reason: String?,
        messageDuration: Duration
    ) {
        guild.ban(user.id) {
            this.reason = reason
            this.deleteMessageDuration = messageDuration
        }
    }

    private suspend fun permissionCheck(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        user: User
    ) {
        val target = args[options.user]
        val deleteMessageDuration = args[options.messageDurationInt] ?: 7

        when {
            Permission.BanMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "I'm currently missing the `BAN_MEMBERS` permission!"
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
                    content = "You're not allowed to ban yourself!"
                }
            }

            0 > deleteMessageDuration -> {
                context.sendEphemeralMessage {
                    content = "You cannot delete less than 0 days worth of messages!"
                }
            }

            7 < deleteMessageDuration -> {
                context.sendEphemeralMessage {
                    content = "You cannot delete more than 7 days worth of messages!"
                }
            }

            else -> return
        }
    }
}

class BanDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks a user from the current guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.BanMembers
        }
        executor = BanExecutor(nabi)
    }
}