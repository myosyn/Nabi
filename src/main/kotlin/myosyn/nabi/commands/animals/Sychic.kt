package myosyn.nabi.commands.animals

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Sychic : Extension() {
    override val name = "sychic"

    override suspend fun setup() {
        publicSlashCommand(::Sychic) {
            name = "Sychic"
            description = "Mommy Sychic"

            action {
                
            }
        }
    }
}