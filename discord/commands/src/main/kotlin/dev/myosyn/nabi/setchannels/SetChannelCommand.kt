package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.channel
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respondingPaginator
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.TextChannel
import dev.myosyn.nabi.GuildConfigurations
import org.koin.core.component.inject


class SetChannelCommand : Extension() {
    override val name: String = "SetChannelCommand"
    val channelManager: GuildConfigurations by inject()

    override suspend fun setup() {
        publicSlashCommand {
            name = "setchannel"
            description = "Sets the specified channel to be the channel for that specific logging."

            check {
                requireBotPermissions(Permission.EmbedLinks, Permission.SendMessages)
            }

            publicSubCommand {
                name = "list"
                description = "Lists all of the channels that are currently logging something."

                action {
                    respondingPaginator {

                    }
                }
            }

            publicSubCommand {
                name = "set"
                description = "Sets a specific channel to log the given activity."

                check {
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.ViewAuditLog, Permission.ManageWebhooks)
                    anyGuild()
                }

                publicSubCommand(::setChannelArguments) {
                    name = "moderation"
                    description = "Sets a channel to log all moderation activities."

                    action {
                        val target = (arguments.targetChannel ?: this.channel.asChannel()) as TextChannel
                    }
                }

                publicSubCommand(::setChannelArguments) {
                    name = "suggestion"
                    description = "Sets a channel to log all suggestion related activities."

                    action {
                        val target = (arguments.targetChannel ?: this.channel.asChannel()) as TextChannel
                    }
                }

                publicSubCommand(::setChannelArguments) {
                    name = "welcome"
                    description = "Sets a channel to log all guild join events."

                    action {
                        val target = (arguments.targetChannel ?: this.channel.asChannel()) as TextChannel
                    }
                }

                publicSubCommand(::setChannelArguments) {
                    name = "leave"
                    description = "Sets a channel to log all guild leave events"

                    action {
                        val target = (arguments.targetChannel ?: this.channel.asChannel()) as TextChannel
                    }
                }

                // I haven't implemented this yet, so this is going to be redundant if I didn't even do any of this so like.
                /*
                publicSubCommand {
                    name = "phishing"
                    description = "Sets a channel to log all phishing related punishments."

                    action {

                    }
                }

                 */
            }

            publicSubCommand {
                name = "reset"
                description = "Removes a specific channel from logging."

                check {
                    hasPermission(Permission.Administrator)
                    requireBotPermissions(Permission.ViewAuditLog, Permission.ManageWebhooks)
                }

                publicSubCommand {
                    name = "moderation"
                    description = "Removes the logging of suggestions from the channel you set it to"

                    action {

                    }
                }
                publicSubCommand {
                    name = "suggestion"
                    description = "Removes the logging of suggestions from the channel you set it to"

                    action {

                    }
                }
            }
        }
    }
    inner class setChannelArguments: Arguments() {
        val targetChannel by optionalChannel {
            name = "channel"
            description = "The channel you want to send the logs to."
        }
    }

    inner class removeChannelArguments: Arguments() {
        val removeTargetChannel by channel {
            name = "channel"
            description = "The channel you want to stop sending logs to."
        }
    }
}
