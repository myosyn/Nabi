package myosyn.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class Shutdown : Extension() {
    override val name = "shutdown"

    override suspend fun setup() {

        ephemeralSlashCommand(::Shutdown) {
            name = "shutdown"
            description = "Owner command. Shuts down the entire bot."

            allowUser(OWNER_ID)
        }
    }
}