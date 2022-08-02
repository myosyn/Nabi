package dev.myosyn.nabi.myosyn

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

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
                        color = DEFAULT_COLOR
                        title = "Euphoria Download Link"
                        description = "Hey! Euphoria isn't available for download yet." +
                                "We'll keep you informed when the mod releases" +
                                "Thank you!"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}