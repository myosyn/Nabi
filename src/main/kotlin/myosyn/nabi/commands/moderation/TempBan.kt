package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class TempBan : Extension() {
    override val name = "tempban"

    override suspend fun setup() {
        publicSlashCommand(::TempBan) {
            name = "tempban"
            description = "Bans a user temporarily."
            check {
                hasPermission()
            }
        }
    }
}