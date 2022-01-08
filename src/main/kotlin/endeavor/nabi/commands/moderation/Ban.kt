package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.AuditLogChangeKey
import com.kotlindiscord.kord.extensions.sentry.BreadcrumbType
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.behavior.ban

@Suppress("DuplicatedCode")
class Ban : Extension() {
    override val name = "ban"

    override suspend fun setup() {

        publicSlashCommand(::Ban) {
            name = "ban"
            description = "Throws the clowns out of the circus."
            check {
                hasPermission(AuditLogChangeKey.Permissions.Ban())
                requireBotPermissions()
            }


    class BanArgs : Arguments() {
        val userArguments by user("banUser", "Person to ban")
        val message by int("messages", "Messages")
        val reasons by defaultingString("reason", "The reason for the ban", "No reason provided.")
    }
}





