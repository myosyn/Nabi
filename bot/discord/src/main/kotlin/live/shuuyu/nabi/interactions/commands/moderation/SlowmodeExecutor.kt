package live.shuuyu.nabi.interactions.commands.moderation

import dev.kord.core.cache.data.ChannelData
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.NabiCore

class SlowmodeExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = channel("channel", "The channel you want to slow down.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }

    private suspend fun timeoutUser(nabi: NabiCore, data: SlowmodeData) {
        val guild = Guild(data.guild, nabi.kord)
        val channel = data.channel

        channel.rateLimitPerUser
    }

    class SlowmodeData(
        val guild: GuildData,
        val channel: ChannelData
    )
}