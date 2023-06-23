package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.edit
import dev.kord.core.cache.data.MemberData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

class TimeoutExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to timeout.")

        // val duration = duration("duration", "The amount of time you want to timeout the user for.")
        val reason = optionalString("reason", "The reason why this user was timed out")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."

        val guildId = (context as? GuildApplicationCommandContext)!!.guildId

        val member = Member(
            MemberData.from(target.id, guildId, nabi.rest.guild.getGuildMember(guildId, target.id)),
            UserData.from(nabi.rest.user.getUser(target.id)),
            nabi.kord
        )

        // The duration is currently temporary because I need to do something with integer scaling
        timeoutUser(member, reason, Duration.ZERO)
    }

    private suspend fun timeoutUser(
        member: Member,
        reason: String?,
        duration: Duration
    ) {

        member.edit {
            // This is apparently the timeout thing, which makes zero sense
            this.communicationDisabledUntil = Clock.System.now().plus(duration)
            this.reason = reason
        }
    }

    private suspend fun checkPermissions(
        context: ApplicationCommandContext,
        args: SlashCommandArguments,
        guild: Guild,
        // This user is the punisher, not the person being timed out.
        moderator: User
    ) {
        val target = args[options.user]

        if (context !is GuildApplicationCommandContext)
            return

        when {
            Permission.ModerateMembers !in context.appPermissions -> {
                context.sendEphemeralMessage {

                }
            }

            target.isBot -> {
                context.sendEphemeralMessage {
                    content = "I'm not allowed to timeout bots!"
                }
            }

            target.id == guild.ownerId -> {
                context.sendEphemeralMessage {

                }
            }

            target.id == moderator.id -> {
                context.sendEphemeralMessage {
                    content = "You're not allowed to timeout yourself!"
                }
            }

            else -> return
        }
    }
}

class TimeoutDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("timeout", "Times out the specified user.") {

        defaultMemberPermissions = Permissions {
            +Permission.ModerateMembers
        }

        executor = TimeoutExecutor(nabi)
    }
}