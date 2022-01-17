package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
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
            requireBotPermissions(Permission.ManageRoles)

            check {
                anyGuild()
                hasPermission(Permission.ManageRoles)
            }

            action {


            }
        }
    }
}