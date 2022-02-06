package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class Warn : Extension() {
    override val name = "warn"

    override suspend fun setup() {
        publicSlashCommand(::WarnArguments) {
            name = "Warn"
            description = "Warns the user for their action."
            requireBotPermissions(Permission.ModerateMembers)

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
            }

            action {

            }
        }
    }
}