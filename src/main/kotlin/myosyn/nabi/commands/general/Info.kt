package myosyn.nabi.commands.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

class Info : Extension() {
    override val name = "info"

    override suspend fun setup() {
        ephemeralSlashCommand(::Info) {
            name = "Info"
            description = "Displays info about Nabi"

            action {
                respond {
                    content = "I'll do this later so don't ask me"

                    embed {

                    }
                }
            }
        }
    }
}