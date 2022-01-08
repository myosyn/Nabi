package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Ban : Extension() {
    override val name = "ban"

    override suspend fun setup() {

        publicSlashCommand(::Ban) {
            name = "ban"
            description = "Throws the clowns out of the circus."
        }
    }
}