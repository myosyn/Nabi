package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel

// TODO: Make it so all of the messages will direct to a hastebin after being deleted

class PurgeCommand : Extension() {
    override val name: String = "PurgeCommand"

    override suspend fun setup() {
        publicSlashCommand(::PurgeCommandArguments) {
            name = "purge"
            description = "Deletes a select amount of messages and uploads all of the deleted messages to hastebin"

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val intmessages = arguments.intmessages
                val channel = (arguments.channel?.asChannel() ?: this.channel.asChannel()) as TextChannel

                channel.edit {

                }
            }
        }
    }

    inner class PurgeCommandArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "The channel you want to clear messages from. Defaults to the channel you're in."
        }
        val intmessages by defaultingInt {
            name = "Messages"
            description = "The number of messages you want to delete."
            defaultValue = 5
            validate {
                 if (value < 0) {
                     throw DiscordRelayedException("You cannot delete nothing. That is like dividing by zero. Input a value and try again you idiot.")
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