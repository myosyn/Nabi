package myosyn.nabi.extensions.moderation

import com.kotlindiscord.kord.extensions.DISCORD_BLURPLE
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalDuration
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.behavior.channel.threads.edit
import dev.kord.core.entity.channel.Channel
import dev.kord.core.entity.channel.thread.TextChannelThread

class LockChannel : Extension() {
    override val name: String = "lockchannel"

    override suspend fun setup() {
        publicSlashCommand(::LockChannelArguments){
            name = "LockChannel"
            description = "Locks down the channel so no one but the highest roles can talk."
            requireBotPermissions(Permission.ManageChannels)

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
            }

            action {
                val channel: Channel = if (arguments.channel != null) {
                    arguments.channel!!
                } else {
                    channel.asChannel()
                }

                if (channel is TextChannelThread) {
                    channel.edit {
                        locked = true
                        reason = arguments.reason
                    }

                    channel.createEmbed {
                        color = DISCORD_BLURPLE
                        title = "Channel Locked"
                        description = "This channel was locked for ${arguments.reason}"
                    }
                }
            }
        }
    }
    inner class LockChannelArguments : Arguments() {
        val reason by optionalString {
            name = "reason"
            description = "Lists why the channel was locked."
        }
        val channel by optionalChannel {
            name = "channel"
            description = "The channel you want to lock down (Within the server of course)"
        }
        val duration by optionalDuration {
            name = "duration"
            description = "The duration of how long you want the channel to be locked down for. Leave blank if you want the channel to be locked indefinitely."
        }
    }
}