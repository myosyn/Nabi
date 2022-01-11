package myosyn.nabi.commands.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand

class Info : Extension() {
    override val name = "info"

    override suspend fun setup() {
        ephemeralSlashCommand(::Info) {
            name = "Info"
            description = "Displays info about Nabi"

            action {
                I'll do this later'

                }
            }
        }
    }
}