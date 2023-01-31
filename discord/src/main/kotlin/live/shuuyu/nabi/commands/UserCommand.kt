package live.shuuyu.nabi.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class UserCommand : Extension() {
    override val name: String = "user"
    override val bundle: String = "nabi.UserCommand"

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
                        title = translate("embed.title", arrayOf(target.username, target.discriminator))
                        field {
                            name = translate("embed.UserInformation.title")
                        }
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}

class UserArguments : Arguments() {
    val user by optionalUser {
        name = "user"
        description = "The user you want to look up."
    }
}