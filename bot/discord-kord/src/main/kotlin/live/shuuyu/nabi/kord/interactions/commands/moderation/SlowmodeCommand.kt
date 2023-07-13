package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.channel.edit
import dev.kord.core.behavior.channel.threads.edit
import dev.kord.core.cache.data.ChannelData
import dev.kord.core.entity.User
import dev.kord.core.entity.channel.Channel
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.entity.channel.thread.ThreadChannel
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import live.shuuyu.nabi.kord.utils.ColorUtils
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds

class SlowmodeExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val duration = string("duration", "The duration you want to slow the channel by.")
        val channel = optionalChannel("channel", "The channel you want to slow down.")
        val reason = optionalString("reason", "The reason why this channel is being slowed down.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val targetChannel = args[options.channel] ?:
            Channel.from(ChannelData.from(rest.channel.getChannel(context.channelId)), kord)
        val reason = args[options.reason] ?: "No reason provided"

        if(validateSlowmode(context, args))
            return slowmodeChannel(targetChannel, reason, context.sender, context, args)
    }

    private suspend fun slowmodeChannel(
        channel: Channel,
        reason: String,
        user: User,
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments
    ) {
        val duration = Duration.parse(args[options.duration])

        when (channel) {
            is TextChannel -> channel.edit { rateLimitPerUser = duration }

            is ThreadChannel -> channel.edit { rateLimitPerUser = duration }

            else -> context.sendEphemeralMessage { content = "You can't set a slowmode for this channel type!" }
        }

        context.sendMessage {
            createSlowmodeConfirmationEmbed(duration, channel, reason, user)
        }
    }

    private suspend fun validateSlowmode(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
    ): Boolean {
        val duration = Duration.parse(args[options.duration])

        when {
            Permission.ManageChannels !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "**I'm currently missing the `MANAGE_CHANNELS` permission!**"
                }
                return false
            }

            duration > 6.hours -> {
                context.sendEphemeralMessage {
                    content = "**You cannot slow down this channel for this long! It must be at most 6 hours.**"
                }
                return false
            }

            duration < 0.seconds -> {
                context.sendEphemeralMessage {
                    content = "**You cannot slow down a channel for this amount of time! It must be more than 0 seconds.**"
                }
                return false
            }

            else -> return true
        }
    }

    private fun InteractionOrFollowupMessageCreateBuilder.createSlowmodeConfirmationEmbed(
        duration: Duration,
        channel: Channel,
        reason: String,
        moderator: User
    ) {
        embed {
            title = "Set Slowmode for ${channel.data.name.value}"
            description = "This channel has been slowed by **$duration** for **$reason**. \n" +
                    "**Moderator:** ${moderator.mention}"
            color = ColorUtils.SUCCESS_COLOR
            timestamp = Clock.System.now()
        }
    }
}

class SlowmodeDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows down the requested channel.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageChannels
        }

        dmPermission = false

        executor = SlowmodeExecutor(nabi)
    }
}