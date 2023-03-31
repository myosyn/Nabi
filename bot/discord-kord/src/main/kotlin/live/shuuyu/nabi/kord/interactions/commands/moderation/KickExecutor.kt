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

class KickExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to kick from the server.")
        val reason = optionalString("reason", "The reason why this user is being kicked.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val user = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."
        val rest = nabi.rest

        /*
        val KickData = KickData(
            reason,
            guild.data,
            user.data
        )
         */
    }

    private suspend fun kick(data: KickData) {
        val reason = data.reason
        val guild = Guild(data.guild, nabi.kord)
        val user = User(data.user, nabi.kord)

        guild.kick(user.id, reason)
    }

    class KickData(
        val reason: String?,
        val guild: GuildData,
        val user: UserData,
    )
}