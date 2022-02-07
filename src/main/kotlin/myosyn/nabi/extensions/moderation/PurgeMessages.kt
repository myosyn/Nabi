package myosyn.nabi.extensions.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.sentry.BreadcrumbType
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior
import kotlinx.coroutines.flow.*

class PurgeMessages : Extension() {

    override val name :String
        get() = "PurgeMessages"

    override suspend fun setup() {

        publicSlashCommand(::PurgeMessagesArguments) {
            name = "purge"
            description = "Clears a selected amount of messages that are within the 2 week range."
            requireBotPermissions(Permission.ManageMessages, Permission.ReadMessageHistory)

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
            }

            action {
                val messageAmount = arguments.messages
                val textChannel = channel as GuildMessageChannelBehavior

                sentry.breadcrumb(BreadcrumbType.Info) {
                    category = "extensions.commands.moderation.clear.getMessages"
                    message = "Gathering message amount"
                    data["amount"] = messageAmount
                }

                channel.getMessagesBefore(channel.messages.last().id, Integer.min(messageAmount, 1000)).filterNotNull()
                    .onEach {
                        messageHolder.add(it.id)

                    }.catch {
                        it.printStackTrace()
                        println("error")
                    }


            }
        }
    }
    inner class PurgeMessagesArguments : Arguments() {
        val amount by defaultingInt {
            name = "count"
            description = "The amount of messages you want to delete within the range of 1-100. The default value is 1."
            defaultValue = 1
            ignoreErrors = false
        }

    }
}

