package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class UserCommand : Extension() {
    override val name: String = "User"

    override suspend fun setup() {
        publicSlashCommand(::UserArguments) {
            name = "User"
            description = "Looks up a user."

            check {
                anyGuild()
            }

            action {

            }
        }
        ephemeralSlashCommand(::UserArguments) {
            name = "SilentUser"
            description = "Looks up a user, but you can only see it."

            check {
                anyGuild()
            }

            action {

            }
        }
    }
    inner class UserArguments : Arguments() {
        val user by optionalString {
            name = "User"
            description = "Searches up a user. If left blank, then it f"
        }
    }
}