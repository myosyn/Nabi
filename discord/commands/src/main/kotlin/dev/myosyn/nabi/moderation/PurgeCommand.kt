package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.*
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock

// TODO: Make it so all of the messages will direct to a hastebin after being deleted

class PurgeCommand : Extension() {
    override val name: String = "PurgeCommand"

    override suspend fun setup() {
        publicSlashCommand(::PurgeArguments) {
            name = "Purge" + "ClearMessages"
            description = "Clears the specified amount of messages from the channel, if the messages are under 2 weeks old."

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val messageAmount = arguments.intmessages
                val channel = channel as GuildMessageChannelBehavior
                val reason = arguments.reason

                respond {
                    embed {
                        color = SUCCESS_COLOR
                        title = "Cleared Messages"
                        description = "Cleared a total of ${arguments.intmessages} in ${arguments.channel} for $reason."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }

        ephemeralSlashCommand(::PurgeArguments) {
            name = "EphemeralPurge" + "EphemeralClearMessages"
            description = "Ephemerally clears the specified amount of messages from the channel, if the messages are under 2 weeks old."

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val messageAmount = arguments.intmessages
                val channel = channel as GuildMessageChannelBehavior
                val reason = arguments.reason

                respond {
                    embed {
                        color = SUCCESS_COLOR
                        title = "Cleared Messages"
                        description = "Cleared a total of $messageAmount in $channel for $reason."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }

    inner class PurgeArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "The channel you want to clear messages from. Defaults to the channel you're in."
            validate {
                if(null == true) {

                }
            }
        }
        val intmessages by defaultingInt {
            name = "Messages"
            description = "The number of messages you want to delete."
            defaultValue = 5
            validate {
                if(value == 0) {
                    throw DiscordRelayedException("You cannot clear nothing. Imagine dividing zero by zero. See how that works.")
                }
            }
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why you purged the messages."
            defaultValue = "No reason provided."
        }
    }
}