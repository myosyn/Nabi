package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions

class RemoveTimeoutCommand : Extension() {
    override val name: String = "RemoveTimeoutCommand"

    override suspend fun setup() {
        publicSlashCommand(::RemoveTimeoutArguments) {
            name = "RemoveTimeout"
            description = "Removes the timeout status from a user."

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
                requireBotPermissions(Permission.ModerateMembers)
            }

            action {
                arguments.user
            }
        }
        ephemeralSlashCommand(::RemoveTimeoutArguments) {
            name = "EphemeralRemoveTimeout"
            description = "Ephemerally removes the timeout status from a user."

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
                requireBotPermissions(Permission.ModerateMembers)
            }
        }
    }

    inner class RemoveTimeoutArguments : Arguments() {
        val user by user {
            name = "user"
            description = "The user you want to remove the timeout status from."
        }
        val reason by optionalString {
            name = "reason"
            description = "The reason why you removed the timeout status from the person."
        }
    }
}