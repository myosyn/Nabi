package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.duration
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class SlowModeCommand : Extension() {
    override val name: String = "SlowMode"

    override suspend fun setup() {
        publicSlashCommand(::SlowModeArguments) {
            name = "SlowMode"
            description = "Makes it so members can only chat after a period of time"

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

            publicSubCommand {
                name = "reset"
                description = "Resets slowmode back to 0 seconds."
            }
        }
    }
    inner class SlowModeArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "The channel which you want to enable slow mode on."
        }
        val DateTimePeriod by duration {
            name = "duration"
        }
    }
}