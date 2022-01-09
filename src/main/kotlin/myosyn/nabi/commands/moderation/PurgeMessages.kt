package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.sentry.BreadcrumbType
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior

class PurgeMessages : Extension() {
    override val name = "purge"

    override suspend fun setup() {

        publicSlashCommand(::PurgeMessages) {
            name = "purge"
            description = "Clears a selected amount of messages that are within the 2 week range."
            check {
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val messageAmount = arguments.messages
                val textChannel = channel as GuildMessageChannelBehavior

                sentry.breadcrumbs(BreadcrumbType.Info) {
                    category = "commands.moderation.clear.getMessages"
                    message = "Gathering messages"
                    data["amount"] = messageAmount


                }
            }
        }
    }

