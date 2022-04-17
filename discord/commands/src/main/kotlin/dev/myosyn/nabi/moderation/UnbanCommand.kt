package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class UnbanCommand : Extension() {
    override val name: String = "unban"

    override suspend fun setup() {
        publicSlashCommand(::UnbanArguments) {
            name = "Unban"
            description = "Unbans a user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {

            }
        }

        ephemeralSlashCommand(::UnbanArguments) {
            name = "SilentUnban"
            description = "Silently unbans a user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }
        }
    }
    inner class UnbanArguments : Arguments() {
        val id by string {
            name = "User ID"
            description = "The User's ID you want to unban."
        }
        val reason by defaultingString {
            name = "Reason"
            description = "The reason why you want to unban the person."
            defaultValue = "No reason provided."
        }
    }
}