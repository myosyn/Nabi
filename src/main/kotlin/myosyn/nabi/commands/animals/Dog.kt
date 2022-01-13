package myosyn.nabi.commands.animals

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Dog : Extension() {
    override val name = "dog"

    override suspend fun setup() {
        publicSlashCommand(::Dog) {
            name = "Dog"
            description = "Cute dogs"
        }
    }
}