package myosyn.nabi.extensions.general

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
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


                if (arguments.user == null)
                    target = arguments.user
                else if (arguments.id != null) {
                    val id = arguments.id!!.toLongOrNull()
                }
            }
        }

        inner class UserArguments : Arguments() {
            val user by optionalUser {
                name = "user"
                description = "A user you want to lookup."
            }
            val id by optionalString {
                name = "id"
                description = "A user's ID you'd like to lookup"
            }
        }
    }
}