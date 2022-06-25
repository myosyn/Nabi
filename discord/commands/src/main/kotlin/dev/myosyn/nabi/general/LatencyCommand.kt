package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

class LatencyCommand : Extension() {
    override val name: String = "Latency"

    override suspend fun setup() {
        publicSlashCommand {
            name = "latency"
            description = "Shows the latency between you and Nabi."

            check {
                anyGuild()
            }

            action {
                val latency = this@LatencyCommand.kord.gateway.averagePing

                respond {
                    embed {
                        title = "Latency"
                        description = "Your latency with Nabi is **$latency**"
                        color = DEFAULT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}