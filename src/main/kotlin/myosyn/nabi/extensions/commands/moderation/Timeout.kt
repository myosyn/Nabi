package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class Timeout : Extension() {
    override val name = "timeout"

    override suspend fun setup() {
        publicSlashCommand(::Timeout) {
            name = "timeout"
            description = "Times out a user, meaning they can't talk."
            check {
                hasPermission(Permission.MuteMembers)
                requireBotPermissions(Permission.MuteMembers)
            }

            action {

            }
        }
    }
}