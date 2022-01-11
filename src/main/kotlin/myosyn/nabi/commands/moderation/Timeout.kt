package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.time.TimestampType
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.hasRole
import dev.kord.common.entity.Permission
import dev.kord.common.entity.UserFlag
import kotlinx.datetime.TimeZone
import java.time.Clock

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