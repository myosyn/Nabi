package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.GuildChannelBehavior

class LockChannelCommand : Extension() {
    override val name: String = "LockChannel"

    override suspend fun setup() {
        publicSlashCommand(::LockchannelArguments) {
            name = "LockChannel"
            description = "Locks the specified channel. Defaults to the channel you're currently in."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }
            action {
                val channel = arguments.channel as GuildChannelBehavior
                val reason = arguments.reason
            }
        }

        ephemeralSlashCommand(::LockchannelArguments) {
            name = "EphemeralLockChannel"
            description = "Ephemerally locks the specified channel. Defaults to the channel you're currently in."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

            action {

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