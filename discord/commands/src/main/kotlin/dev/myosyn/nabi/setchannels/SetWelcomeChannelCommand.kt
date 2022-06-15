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
import dev.kord.rest.builder.message.create.embed

class SetWelcomeChannelCommand : Extension() {
    override val name: String = "SetWelcomeChannel"

    override suspend fun setup() {
        publicSlashCommand {
            name = "WelcomeChannel"
            description = "Configures the welcome channel."

            publicSubCommand(::SetWelcomeChannelArguments) {
                name = "set"
                description = "Sets the specified channel to be the welcome channel."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.Administrator)
                }

                action {
                    val target = arguments.channel ?: this.channel.asChannel()


                }
            }

            publicSubCommand {
                name = "reset"
                description = "Resets the welcome channel."

                check {
                    anyGuild()
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.Administrator)
                }
            }
        }
    }

    inner class SetWelcomeChannelArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "Sets the specified channel to be the welcoming channel."
        }
    }
}