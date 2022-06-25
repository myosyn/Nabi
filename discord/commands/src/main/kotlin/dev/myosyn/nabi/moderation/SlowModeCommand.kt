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
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock

class SlowModeCommand : Extension() {
    override val name: String = "SlowMode"

    override suspend fun setup() {
        publicSlashCommand(::SlowModeArguments) {
            name = "slowmode"
            description = "Makes it so members can only chat after a period of time"

            publicSubCommand(::SlowModeArguments) {
                name = "set"
                description = "Sets the slowmode to the specified amount."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageChannels)
                    requireBotPermissions(Permission.ManageChannels)
                }

                action {
                    val channel = (arguments.slowmodeChannel?.asChannel() ?: this.channel.asChannel()) as TextChannel

                    channel.edit {

                    }

                    respond {
                        embed {
                            title = "Slowmode Set"
                            color = SUCCESS_COLOR
                            timestamp = Clock.System.now()
                        }
                    }
                }
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
                    val channel = (arguments.slowmodeChannel ?: this.channel.asChannel()) as TextChannel


                    channel.edit {

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