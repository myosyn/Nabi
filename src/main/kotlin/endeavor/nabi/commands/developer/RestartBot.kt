package endeavor.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import endeavor.nabi.utils.OWNER_ID

class RestartBot : Extension() {
    override val name = "restart"

    override suspend fun setup() {

        ephemeralSlashCommand(::RestartBot) {
            name = "restart"
            description = "Restarts the entire bot."

            allowUser(OWNER_ID)
        }
    }
}