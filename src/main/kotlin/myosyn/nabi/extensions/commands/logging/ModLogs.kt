package myosyn.nabi.extensions.commands.logging

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed

class ModLogs : Extension() {
    override val name = "modlogs"

    override suspend fun setup() {
        ephemeralSlashCommand(::ModLogs) {
            name = "ModLogs"
            description = "Sets the selected channel to display all logs from this Discord bot."
            check {
                hasPermission(Permission.Administrator)
                requireBotPermissions(Permission.Administrator)
            }

            action {

            }
        }
    }
}
