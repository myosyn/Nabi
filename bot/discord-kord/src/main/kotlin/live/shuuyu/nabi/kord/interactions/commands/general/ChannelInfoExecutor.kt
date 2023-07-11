package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.core.cache.data.ChannelData
import dev.kord.core.entity.channel.Channel
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class ChannelInfoExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel which you want to look up information on.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.channel] ?: Channel.from(ChannelData.from(rest.channel.getChannel(context.channelId)), kord)
    }
}

class ChannelInfoDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("channelinfo", "Looks up information on the requested channel.") {
        executor = ChannelInfoExecutor(nabi)
    }
}