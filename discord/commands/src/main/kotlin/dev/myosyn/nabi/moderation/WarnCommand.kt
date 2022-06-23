package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class WarnCommand : Extension() {
    override val name: String = "warn"

    override suspend fun setup() {
        publicSlashCommand(::WarnArguments) {
            name = "Warn"
            description = "Warns the user for the crime that they committed."

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
            }

            action {

            }
        }
    }
    inner class WarnArguments : Arguments() {
        val user by user {
            name = "user"
            description = "The user you want to ban."
        }
        val reason by optionalString {
            name = "reason"
            description = "The reason why the user is getting warned."
        }
    }
}