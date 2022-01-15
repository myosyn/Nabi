package myosyn.nabi.commands.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import com.kotlindiscord.kord.extensions.DISCORD_YELLOW
import kotlinx.datetime.Clock

@Suppress("PrivatePropertyName")
class Ping : Extension() {
    override val name = "ping"

    override suspend fun setup() {
        ephemeralSlashCommand(::Ping) { // ephemeralSlashCommands can only be seen by yourself.
            name = "ping"
            description = "Pings Nabi to test if she is online."

            action {
                val averagePing = this@Ping.kord.gateway.averagePing

                respond {
                    embed {
                        color = "DISCORD_YELLOW"
                        title = "A request has been sent back"

                        timestamp = Clock.System.now()

                        field {
                            name = "Your ping with Nabi is:"
                            value = "**$averagePing**"
                            inline = true
                        }
                    }
                }
            }

        }

    }
}
