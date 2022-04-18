package dev.myosyn.nabi.myosyn

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed

class EuphoriaDownload : Extension() {
    override val name: String = "EuphoriaDownload"

    override suspend fun setup() {
        publicSlashCommand {
            name = "EuphoriaDownload"
            description = "Shows the download page to Euphoria"

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        color = Color(213, 154, 255)
                        title = "Euphoria Download Link"
                        description = "Hey! Euphoria isn't available for download yet. Please understand that we're in active development of the mod. Thanks!"
                    }
                }
            }
        }
    }
}