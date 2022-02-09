package myosyn.nabi.extensions.logging

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.channel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.event
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.event.guild.MemberJoinEvent
import dev.kord.rest.builder.message.create.embed

class ModerationLogging : Extension() {
    override val name: String = "ModerationLogging"

    override suspend fun setup() {
        event<MemberJoinEvent> {
            check {
                isModuleEnabled(Modules.Logging)
            }

            action {
                event.guild.getLogChannel()?.CreateEmbed {

                }
            }
        }

        ephemeralSlashCommand(::ModerationLoggingArgument) {
            name = "ModLogs"
            description = "Sets the selected channel to display all logs from this Discord bot."
            requireBotPermissions(Permission.Administrator)

            check {
                anyGuild()
                hasPermission(Permission.Administrator)
            }

            action {
                val channelArgument= arguments.channelArguments
                

            }
        }
    }
    inner class ModerationLoggingArgument : Arguments() {
        val channel by optionalChannel {
            name = "channel"
            description = "The channel (id) you want to send all of your logs to."
        }
    }
}
