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

class UnlockChannelCommand : Extension() {
    override val name: String = "UnlockChannel"

    override suspend fun setup() {
        publicSlashCommand(::UnlockChannelArguments) {
            name = "UnlockChannel"
            description = "Unlocks the locked channel."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

            action {

            }
        }

        ephemeralSlashCommand(::UnlockChannelArguments) {
            name = "EphemeralUnlockChannel"
            description = "Ephemerally unlocks the specified channel."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

            action {

            }
        }
    }

    inner class UnlockChannelArguments : Arguments() {
        val channel by optionalString {
            name = "Channel"
            description = "The channel you want to unlock."
        }
        val reason by defaultingString {
            name = "Reason"
            description = "The reason why you unlocked the channel"
            defaultValue = "No reason provided"
        }
    }
}