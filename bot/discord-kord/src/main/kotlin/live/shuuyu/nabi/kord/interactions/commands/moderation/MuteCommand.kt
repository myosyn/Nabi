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
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration

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

        val memberData = MemberData.from(target.id, context.guildId, rest.guild.getGuildMember(context.guildId, target.id))

        if(validateMute(context, args, Guild(GuildData.from(rest.guild.getGuild(context.guildId)), kord), context.sender))
            return timeoutUser(MuteData(memberData, target.data, reason, muteDuration))
    }

    private suspend fun timeoutUser(data: MuteData) {
        val member = Member(data.member, data.user, kord)

        member.edit {
            communicationDisabledUntil = Clock.System.now().plus(data.timeoutDuration)
            reason = data.reason
        }
    }

    private suspend fun validateMute(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        moderator: User
    ): Boolean {
        val target = args[options.user]

        when {
            Permission.ModerateMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "I don't have the required permissions to run this command!"
                }
                return false
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "I'm not allowed to timeout bots!"
                }
                return false
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {
                    content = "I am not allowed to timeout the owner!"
                }
                return false
            }

            target.id == moderator.id -> {
                context.sendEphemeralMessage {
                    content = "You're not allowed to timeout yourself!"
                }
                return false
            }

            else -> return true
        }
    }

    private class MuteData(
        val member: MemberData,
        val user: UserData,
        val reason: String,
        val timeoutDuration: Duration
    )
}

class MuteDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("mute", "Mutes the specified user.") {
        defaultMemberPermissions = Permissions {
            +Permission.ModerateMembers
        }

        executor = MuteExecutor(nabi)
    }
}