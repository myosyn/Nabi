package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.duration
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand
import io.github.qbosst.kordex.commands.hybrid.publicSubCommand

class SlowModeCommand : Extension() {
    override val name: String = "SlowMode"

    override suspend fun setup() {
        publicHybridCommand(::SlowModeArguments) {
            name = "SlowMode"
            description = "Makes it so members can only chat after a period of time"

            publicSubCommand(::SlowModeArguments) {
                name = "reset"
                description = "Resets slowmode back to 0 seconds."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageChannels)
                    requirePermissions(Permission.ManageChannels)
                }

                action {
                    val channel = this.channel.asChannel() as TextChannel

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