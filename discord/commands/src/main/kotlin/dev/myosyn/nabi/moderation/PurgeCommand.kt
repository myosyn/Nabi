package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.*
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

// TODO: Make it so all of the messages will direct to a hastebin after being deleted

class PurgeCommand : Extension() {
    override val name: String = "PurgeCommand"

    override suspend fun setup() {
        publicHybridCommand(::PurgeCommandArguments) {
            name = "purge"
            description = "Deletes a select amount of messages and uploads all of the deleted messages to hastebin"

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
                requirePermissions(Permission.ManageMessages)
            }

            action {
                val amtmessages = arguments.intmessages
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
            validate {

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