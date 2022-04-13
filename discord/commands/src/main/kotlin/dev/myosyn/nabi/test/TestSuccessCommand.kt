package dev.myosyn.nabi.test

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class TestSuccessCommand : Extension() {
    override val name: String = "testsuccess"

    override suspend fun setup() {
        publicSlashCommand {
            name = "TestSuccess"
            description = "Tests if success will work (Which will never happen)"

            action {
                respond {
                    embed {
                        color = Color(134, 255, 134  )
                        title = "Command Successfully Executed"
                        description = "You did nothing though >:("
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}