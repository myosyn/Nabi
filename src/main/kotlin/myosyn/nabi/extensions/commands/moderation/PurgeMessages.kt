package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior

class PurgeMessages : Extension() {

    override val name :String
        get() = "PurgeMessages"

    override suspend fun setup() {

        publicSlashCommand(::PurgeMessagesArguments) {
            name = "purge"
            description = "Clears a selected amount of messages that are within the 2 week range."
            check {
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val messageAmount = arguments.messages
                val textChannel = channel as GuildMessageChannelBehavior

                val amount = (arguments.amount.toIntorNull() ?: 0)


            }
        }
    }
    inner class PurgeMessagesArguments : Arguments() {
        val count by defaultingInt {
            name = "count"
            description = "The amount of messages you want to delete within the range of 1-100."

        }
    }
}

