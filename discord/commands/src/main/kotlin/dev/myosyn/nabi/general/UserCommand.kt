package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

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
                val target = arguments.userArgs

                respond {
                    embed {

                    }
                }
            }
        }
    }
    inner class UserArguments : Arguments() {
        val userArgs by optionalString {
            name = "User"
            description = "Searches up a user. If left blank, then it f"
        }
    }
}