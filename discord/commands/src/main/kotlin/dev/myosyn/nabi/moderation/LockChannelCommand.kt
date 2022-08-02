package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class LockChannelCommand : Extension() {
    override val name: String = "LockChannel"

    override suspend fun setup() {
        publicSlashCommand(::LockchannelArguments) {
            name = "channel"
            description = "Locks the specified channel. Defaults to the channel you're currently in."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }
            action {
                val targetChannel = (arguments.channel ?: this.channel.asChannel()) as TextChannel
                val providedReason = arguments.reason

                targetChannel.edit {

                }

                respond {
                    embed {
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }

    inner class LockchannelArguments : Arguments() {
        val channel by optionalString {
            name = "Channel"
            description = "The channel you want to lock. Defaults to the channel that you are in."
        }
        val time by optionalString {
            name = "Time"
            description = "The amount of time you want to lock this channel for."
        }
        val reason by defaultingString {
            name = "Reason"
            description = "The reason why you're locking this channel."
        }
    }
}