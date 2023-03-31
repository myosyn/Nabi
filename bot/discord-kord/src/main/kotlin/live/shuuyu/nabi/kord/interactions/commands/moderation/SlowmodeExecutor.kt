package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.cache.data.ChannelData
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.channel.Channel
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore

class SlowmodeExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = channel("channel", "The channel you want to slow down.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }

    private suspend fun timeoutUser(nabi: NabiKordCore, data: SlowmodeData) {
        val guild = Guild(data.guild, nabi.kord)
        val channel = Channel.from(data.channel, nabi.kord)


    }

    class SlowmodeData(
        val guild: GuildData,
        val channel: ChannelData
    )
}