package myosyn.nabi.extensions.commands.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.DISCORD_WHITE
import dev.kord.rest.builder.message.create.embed

class Info : Extension() {
    override val name = "info"

    override suspend fun setup() {
        ephemeralSlashCommand(::InfoArguments) {
            name = "Info"
            description = "Displays info about Nabi"

            action {
                respond {
                    embed {
                        color = DISCORD_WHITE
                        title = "What is Nabi?"

                        field {
                            name = "Nabi is an open source Discord bot written in Kotlin."
                            inline = true
                        }
                    }
                }
            }
        }
    }
}