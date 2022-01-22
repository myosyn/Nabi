package myosyn.nabi.extensions.commands.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.DISCORD_WHITE
import dev.kord.rest.builder.message.create.embed

class Info : Extension() {
    override val name = "info"

    override suspend fun setup() {

        ephemeralSlashCommand {
            name = "Info"
            description = "Displays info about Nabi"

            action {
                respond {
                    embed {
                        color = DISCORD_WHITE
                        title = "What is Nabi?"
                        description =
                            "Nabi is an open source Discord bot built to the ground up with Kotlin. We use the Kord and the Kord-Extension library. You can find the source code at our Github page >>> https://github.com/myosyn/Nabi"

                    }
                }
            }
        }
    }
}