package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

class HelpCommand : Extension() {
    override val name: String = "help"

    override suspend fun setup() {
        publicSlashCommand {
            name = "help"
            description = "Shows you some stuff"

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {

                    }
                }
            }
        }
    }
}