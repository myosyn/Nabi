package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.channel.edit
import dev.kord.core.behavior.channel.threads.edit
import dev.kord.core.cache.data.ChannelData
import dev.kord.core.entity.channel.Channel
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.entity.channel.thread.ThreadChannel
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration

class SlowmodeExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val duration = string("duration", "The duration you want to slow the channel by.")
        val channel = optionalChannel("channel", "The channel you want to slow down.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val targetChannel = args[options.channel] ?:
            Channel.from(ChannelData.from(rest.channel.getChannel(context.channelId)), kord)

        slowmodeChannel(targetChannel, context as GuildApplicationCommandContext, args)
    }

    private suspend fun slowmodeChannel(
        channel: Channel,
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments
    ) {
        when (channel) {
            is TextChannel -> {
                channel.edit {
                    rateLimitPerUser = Duration.parse(args[options.duration])
                }
            }

            is ThreadChannel -> {
                channel.edit {
                    rateLimitPerUser = Duration.parse(args[options.duration])
                }
            }

            else -> context.sendEphemeralMessage { content = "You can't set a slowmode for this channel type!" }
        }
    }
}

class SlowmodeDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows down the requested channel.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageChannels
        }

        executor = SlowmodeExecutor(nabi)
    }
}