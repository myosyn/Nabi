package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock
import java.util.*

class BotInfoCommand : Extension() {
    override val name: String = "info"

    override suspend fun setup() {
        publicSlashCommand {
            name = "Info"
            description = "Shows the info of the bot."

            check {
                anyGuild()
            }

            action {
                val javaVersion = System.getProperty("java.version")
                val osName = System.getProperty("os.name")
                val osRevision = System.getProperty("os.version")
                val kotlinVersion =

                respond {
                    embed {
                        title = "Nabi"
                        field {
                            name = "Java Version"
                            value = javaVersion
                            inline = true
                        }
                        field {
                            name = "Operating System"
                            value = osName
                            inline = true
                        }
                        field {
                            name = "OS Revision Version"
                            value = osRevision
                            inline = true
                        }
                        footer {
                            text = "Made by Myosyn. Licensed under the CC-BY-NC-SA-4.0 license."
                        }
                        color = DEFAULT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}