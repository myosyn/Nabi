package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

class ServerCommand : Extension() {
    override val name: String = "Server"

    override suspend fun setup() {
        publicSlashCommand {
            name = "Server"
            description = "Shows the information of the Discord Server you're currently in."

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        title = ""
                    }
                }
            }
        }
    }
}