package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore

class TimeoutExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to timeout.")

        // val duration = duration("duration", "The amount of time you want to timeout the user for.")
        val reason = optionalString("reason", "The reason why this user was timed out")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }

    private suspend fun timeout(nabi: NabiKordCore, data: TimeoutData) {
        val guild = Guild(data.guild, nabi.kord)
        val user = User(data.user, nabi.kord)


    }

    class TimeoutData(
        val guild: GuildData,
        val user: UserData,
    )
}