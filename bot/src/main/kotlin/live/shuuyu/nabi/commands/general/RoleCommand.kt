package live.shuuyu.nabi.commands.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class RoleCommand : Extension() {
    override val name: String = "role"

    override suspend fun setup() {
        publicSlashCommand(::RoleArguments) {
            name = this@RoleCommand.name
            description = "Looks up information about the provided role."

            check {
                anyGuild()
            }

            action {
                val target = arguments.role

                respond {
                    embed {
                        title = "**${target.name}**"
                        field {
                            name = "Role:"
                            value = target.mention
                        }
                        field {
                            name = "Role Id:"
                            value = target.id.toString()
                        }
                        field {
                            name = "Created At:"
                            value = "${target.id.increment}"
                        }
                        color = target.color
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}

class RoleArguments : Arguments() {
    val role by role {
        name = "role"
        description = "The role you want to look up."
    }
}
