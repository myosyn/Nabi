package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.core.cache.data.ChannelData
import dev.kord.core.entity.channel.Channel
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import live.shuuyu.nabi.kord.utils.ColorUtils
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class ChannelInfoExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel which you want to look up information on.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.channel] ?:
            Channel.from(ChannelData.from(rest.channel.getChannel(context.channelId)), kord)

        context.sendMessage {
            createChannelInfoEmbed(target)
        }
    }

    // This is for legibility sakes. Don't question it.
    private fun InteractionOrFollowupMessageCreateBuilder.createChannelInfoEmbed(channel: Channel) {
        embed {
            title = channel.data.name.value
            description = ""
            color = ColorUtils.DEFAULT_COLOR
            timestamp = Clock.System.now()
        }
    }
}

class ChannelInfoDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("channel", "Looks up information on the requested channel.") {
        dmPermission = false

        executor = ChannelInfoExecutor(nabi)
    }
}