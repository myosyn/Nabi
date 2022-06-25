package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock
import kotlin.system.exitProcess

class ShutdownCommand : Extension() {
    override val name: String = "Shutdown"

    override suspend fun setup() {
        ephemeralSlashCommand {
            name = "Shutdown"
            description = "Shuts down the bot."

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        color = SUCCESS_COLOR
                        title = "Shutdown"
                        description = "The bot will proceed to shutdown as intended."
                        timestamp = Clock.System.now()
                    }
                }
                exitProcess(0)
            }
        }
    }
}