package endeavor.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand

class BotBan: Extension() {
    override val name = "botban"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotBan){
            name = "BotBan"
            description = "Owner only command."
        }
    }
}