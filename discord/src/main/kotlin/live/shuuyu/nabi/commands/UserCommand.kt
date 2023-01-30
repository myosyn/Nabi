package live.shuuyu.nabi.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.UserFlag
import dev.kord.rest.builder.message.create.embed

class UserCommand : Extension() {
    override val name: String = "user"

    override suspend fun setup() {
        publicSlashCommand(::UserArguments) {
            name = this@UserCommand.name
            description = "Looks up a user."

            check {
                anyGuild()
            }

            action {
                val target = arguments.user ?: this.user.asUser()

                respond {
                    embed {

                    }
                }
            }
        }
    }

    private fun getUserFlags(flags: UserFlag): String {
        when (flags) {
            UserFlag.VerifiedBot -> ""
            else -> {} // return with nothing
        }
    }

    inner class UserArguments : Arguments() {
        val user by optionalUser {
            name = "user"
            description = "The user you want to look up."
        }
    }
}