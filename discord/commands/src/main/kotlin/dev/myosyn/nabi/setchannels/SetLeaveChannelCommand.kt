package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission

class SetLeaveChannelCommand : Extension() {
    override val name: String = "SetLeaveChannel"

    override suspend fun setup() {
        publicSlashCommand {
            name = "configure"
            description = "Configures the leave channel."

            publicSubCommand(::SetLeaveChannelArguments) {
                name = "set"
                description = "Sets the specified channel to display the leave messages."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.Administrator)
                }

                action {

                }
            }

            publicSubCommand {
                name = "reset"
                description = "Makes it so you don't have a leave channel anymore."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.Administrator)
                }

                action {
                    respond {

                    }
                }
            }
        }
    }
    inner class SetLeaveChannelArguments : Arguments() {
        val channel by optionalChannel {
            name = "channel"
            description = "The channel you want to send all of your leaves to."
        }
    }
}