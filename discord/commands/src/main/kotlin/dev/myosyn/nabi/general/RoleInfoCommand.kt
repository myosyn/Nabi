package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

class RoleInfoCommand : Extension() {
    override val name: String = "RoleInfo"

    override suspend fun setup() {
        publicSlashCommand(::RoleInfoArguments) {
            name = "roleInfo"
            description = "Shows information about the specified role."

            check {
                anyGuild()
            }

            action {
                val target = arguments.targetRole

                respond {
                    embed {
                        title = "Role information"
                        field {
                            
                        }
                        color = DEFAULT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class RoleInfoArguments : Arguments() {
        val targetRole by role {
            name = "role"
            description = "The role you want to look up. The role has to be within the server."
        }
    }
}