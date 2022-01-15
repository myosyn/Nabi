package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class GiveRole : Extension() {
    override val name: String = "giverole"

    override suspend fun setup() {
        publicSlashCommand(::GiveRole) {
            name = "GiveRole"
            description = "Gives a member the given role."
            check {
                hasPermission(Permission.ManageRoles)
                requireBotPermissions(Permission.ManageRoles)
            }

            action {
                
            }
        }
    }
}