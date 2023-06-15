package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.cache.data.ChannelData
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.channel.Channel
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class SlowmodeExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = channel("channel", "The channel you want to slow down.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        TODO("Not yet implemented")
    }

    private suspend fun slowmode(nabi: NabiKordCore, data: SlowmodeData) {
        val guild = Guild(data.guild, nabi.kord)
        val channel = Channel.from(data.channel, nabi.kord).asChannel()

        channel.asChannel()
    }

    class SlowmodeData(
        val guild: GuildData,
        val channel: ChannelData
    )
}