package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Snowflake
import dev.kord.core.cache.data.GuildData
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore

class BanExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }

    private suspend fun banUser(data: BanData) {

    }

    class BanData(
        val guild: GuildData,
        val reason: String,
        val user: Snowflake
    )
}