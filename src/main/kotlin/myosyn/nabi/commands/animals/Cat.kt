package myosyn.nabi.commands.animals

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Cat : Extension() {
    override val name = "cat"

    override suspend fun setup() {
        publicSlashCommand(::Cat) {
            name = "cat"
            description = "Why did I add this"

            action {

            }
        }
    }
}