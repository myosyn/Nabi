package myosyn.nabi.extensions.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

@Suppress("DuplicatedCode")
class Ban : Extension() {
    override val name: String = "ban"

    override suspend fun setup() {
        publicSlashCommand(::BanArguments) {
            name = "ban"
            description = "Throws the clowns out of the circus."
            requireBotPermissions(Permission.BanMembers)

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
            }

            action {
                val target = guild!!.getMemberOrNull()

            }
        }
    }
    inner class BanArguments : Arguments() {
        val target by user {
            name = "User"
            description = "User to ban from the server"
        }

        val reason by optionalString {
            name = "Reason"
            description = "Why the user was banned from the server"
        }
    }
}


