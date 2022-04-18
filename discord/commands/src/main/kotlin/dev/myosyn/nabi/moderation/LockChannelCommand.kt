package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

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
    }
}