package myosyn.nabi.extensions.commands.general

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.core.entity.User

class User : Extension() {
    override val name: String = "User"

    override suspend fun setup() {
        publicSlashCommand(::UserArguments) {
            name = "User"
            description = "Gives information on the specified user."

            action {
                val target: User?

                if (arguments.user != null)

            }
        }
    }
    inner class UserArguments : Arguments() {
        val user by optionalUser {
            name = "user"
            description = "A user you want to lookup."
        }
    }
}