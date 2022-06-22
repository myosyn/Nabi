package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.duration
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.TextChannel

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

            publicSubCommand(::SlowModeArguments) {
                name = "reset"
                description = "Resets slowmode back to 0 seconds."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageChannels)
                    requireBotPermissions(Permission.ManageChannels)
                }

                action {
                    val slowmodeReset = arguments.slowmodeChannel ?: this.channel.asChannel() as TextChannel

                    channel

                    respond {
                        content = "Slowmode has been reset to 0 seconds."
                    }
                }
            }
        }
    }
    inner class SlowModeArguments : Arguments() {
        val slowmodeChannel by optionalChannel {
            name = "Channel"
            description = "The channel which you want to enable slow mode on."
        }
        val DateTimePeriod by duration {
            name = "duration"
        }
    }
}