package dev.myosyn.nabi.test

import com.kotlindiscord.kord.extensions.DISCORD_BLURPLE
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class TestEmbed : Extension() {
    override val name: String = "testembed"

    override suspend fun setup() {
        publicSlashCommand {
            name = "TestEmbed"
            description = "Tests the embed function to see if it properly works or not."

            action {
                respond {
                    embed {
                        color = Color(30, 215, 96)
                        title = "Test Embed"
                        description = "uwu"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}