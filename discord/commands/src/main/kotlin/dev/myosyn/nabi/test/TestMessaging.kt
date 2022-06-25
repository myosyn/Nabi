package dev.myosyn.nabi.test

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond

class TestMessaging : Extension() {
    override val name: String = "testmessaging"

    override suspend fun setup() {
        publicSlashCommand {
            name = "testMessaging"
            description = "Tests the function of the messaging in Nabi."

            check {
                anyGuild()
            }

            action {
                respond {
                    content = "Hey! Yujin is my beloved :)"
                }
            }
        }

        ephemeralSlashCommand {
            name = "silentTestMessaging"
            description = "Tests the function of the messaging in Nabi but you can only see it."

            check {
                anyGuild()
            }

            action {
                respond {
                    content = "Hey! Yujin is my beloved :)"
                }
            }
        }
    }
}