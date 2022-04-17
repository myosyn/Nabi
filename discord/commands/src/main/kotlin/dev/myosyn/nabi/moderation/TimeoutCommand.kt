package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingTimestamp
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class TimeoutCommand : Extension() {
    override val name: String = "Timeout"

    override suspend fun setup() {
        publicSlashCommand(::TimeoutArguments) {
            name = "Timeout"
            description = "Times out a user"

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
                requireBotPermissions(Permission.ModerateMembers)
            }

            action {

            }
        }
        ephemeralSlashCommand(::TimeoutArguments) {
            name = "SilentTimeout"
            description = "Silently times out a user."

            check {
                anyGuild()
                hasPermission(Permission.ModerateMembers)
                requireBotPermissions(Permission.ModerateMembers)
            }

            action {

            }
        }
    }

    inner class TimeoutArguments : Arguments() {
        val user by user {
            name = "user"
            description = "The user you want to timeout"
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why you want to timeout this person."
            defaultValue = "No reason provided."
        }
        val time by defaultingString {
            name = "time"
            description = "The amount of time you want the user to be timed out for."
            defaultValue = "7d"
        }
    }
}