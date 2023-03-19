package live.shuuyu.nabi.interactions.commands.moderation

import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.NabiCore

class KickExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to kick from the server.")
        val reason = optionalString("reason", "The reason why this user is being kicked.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val user = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."
        // val guild = Guild(GuildData.from(), )

        /*
        val KickData = KickData(
            reason,
            guild.data,
            user.data
        )
         */
    }

    private suspend fun kick(nabi: NabiCore, data: KickData) {
        val reason = data.reason
        val guild = Guild(data.guild, nabi.kord)
        val user = data.user

        guild.kick(user.id, reason)
    }

    class KickData(
        val reason: String?,
        val guild: GuildData,
        val user: UserData,
    )
}