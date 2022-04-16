package dev.myosyn.nabi.test

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock


class TestFailCommand : Extension() {
    override val name: String = "testfail"

    override suspend fun setup() {
        publicSlashCommand {
            name = "TestFail"
            description = "Tests to see if the failing part will work (idk)"

            action {
                respond {
                    embed {
                        color = Color(255, 134, 134 )
                        title = "Error"
                        description = "Looks like this command was successfully executed. Why did it say error?"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }

        ephemeralSlashCommand {
            name = "SilentTestFail"
            description = "Tests to see if failing will work because you are a failure but it only says it to you."

            action {
                respond {
                    embed {
                        color = Color(255, 134, 134 )
                        title = "Error"
                        description = "Looks like this command was successfully executed. Why did it say error?"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
        }
    }
}