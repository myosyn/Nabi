package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.AuditLogChangeKey

class Untimeout : Extension() {
    override val name = "untimeout"

    override suspend fun setup() {
        publicSlashCommand(::Untimeout) {
            name = "untimeout"
            description = "Removes the timeout from someone."
            check {
                hasPermission()
                requireBotPermissions()
            }
        }
    }
}