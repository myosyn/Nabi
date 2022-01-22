package myosyn.nabi.extensions.commands.logging

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.channel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed

class ModLogs : Extension() {
    override val name = "modlogs"

    override suspend fun setup() {
        ephemeralSlashCommand(::ModLogsArgument) {
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
    inner class ModLogsArgument : Arguments() {
        val channelArguments by channel {
            name = "channel"
            description = "The channel you want to send all of your logs to"
        }
    }
}
