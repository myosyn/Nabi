package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Unban : Extension() {
    override val name = "unban"

    override suspend fun setup() {
        publicSlashCommand(::Unban) {
            name = "Unban"
            description = "Unbans a user."
        }
    }
}