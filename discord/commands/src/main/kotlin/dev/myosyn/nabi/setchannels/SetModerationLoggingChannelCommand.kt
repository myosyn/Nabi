package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class SetModerationLoggingChannelCommand : Extension() {
    override val name: String = "SetModerationLoggingChannel"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ModerationLogging"
            description = "Configures the moderation logging channel."

            publicSubCommand(::SetModerationLoggingChannelArguments) {
                name = "set"
                description = "Sets the moderation logging channel."

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
                description = "Removes the moderation logging channel."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.Administrator)
                }
            }
        }
    }
    inner class SetModerationLoggingChannelArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "The channel you want to send all your moderation logs to."
        }
    }
}