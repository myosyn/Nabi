package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class InfoCommand : Extension() {
    override val name: String = "info"

    override suspend fun setup() {
        publicSlashCommand {
            name = "Info"
            description = "Shows the info of the bot."

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        color = Color(30, 215, 96)
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}