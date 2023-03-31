package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.behavior.edit
import dev.kord.core.cache.data.MemberData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Member
import kotlinx.datetime.Clock
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore
import kotlin.time.Duration

class TimeoutExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to timeout.")

        // val duration = duration("duration", "The amount of time you want to timeout the user for.")
        val reason = optionalString("reason", "The reason why this user was timed out")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."


    }

    private suspend fun timeout(nabi: NabiKordCore, data: TimeoutData, duration: Duration) {
        val member = Member(data.member, data.user, nabi.kord)
        val reason = data.reason

        member.edit {
            // This is apparently the timeout thing, which makes zero sense
            this.communicationDisabledUntil = Clock.System.now().plus(duration)
            this.reason = reason
        }
    }

    class TimeoutData(
        val user: UserData,
        val member: MemberData,
        val reason: String?
    )
}