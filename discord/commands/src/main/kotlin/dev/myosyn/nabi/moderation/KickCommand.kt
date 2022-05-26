package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock


class KickCommand : Extension() {
    override val name: String = "Kick"

    override suspend fun setup() {
        publicSlashCommand(::KickArguments) {
            name = "Kick"
            description = "Kicks a user from your server."

            check {
                anyGuild()
                hasPermission(Permission.KickMembers)
                requireBotPermissions(Permission.KickMembers)
            }
            action {
                val user = arguments.reason
                val reason = arguments.reason



                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Kicked User"
                        description = "The user, ${user}, has been kicked for ${reason}."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }

        ephemeralSlashCommand(::KickArguments) {
            name = "EphemeralKick"
            description = "Ephemerally kicks a user from your server."

            check {
                anyGuild()
                hasPermission(Permission.KickMembers)
                requireBotPermissions(Permission.KickMembers)
            }
            action {
                val user = arguments.user
                val reason = arguments.reason

                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Kicked User"
                        description = "The user, ${user}, has been kicked for ${reason}."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class KickArguments : Arguments() {
        val user by user {
            name = "user"
            description = "The user you want to kick"
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why you want to kick the user"
            defaultValue = "No reason provided"
        }
    }
}