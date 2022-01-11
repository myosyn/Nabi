package myosyn.nabi.commands.general

import com.kotlindiscord.kord.extensions.DISCORD_GREEN
import com.kotlindiscord.kord.extensions.DISCORD_YELLOW
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

@Suppress("PrivatePropertyName")
class Ping : Extension() {
    override val name = "ping"

    override suspend fun setup() {
        val actionLog = kord.getGuild(anyGuild)?.getChannel(MOD_ACTION_LOG) as GuildMessageChannelBehavior

        ResponseHelper.responseEmbedInChannel(actionLog, "Nabi is now online!", null, DISCORD_GREEN, null)

        ephemeralSlashCommand(::Ping) { //Public slash commands can be seen by everyone
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
