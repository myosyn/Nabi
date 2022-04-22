package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
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

class BanCommand : Extension() {

    override val name: String = "ban"

    override suspend fun setup() {

        publicSlashCommand(::BanCommandArguments) {
            name = "Ban"
            description = "Bans the specified user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val target = arguments.user
                val reason = arguments.reason

                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Banned User"
                        description = "The user, $user"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }

        ephemeralSlashCommand(::BanCommandArguments) {
            name = "EphemeralBan"
            description = "Silently bans the specified user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }
            action {
                val target = arguments.user
                val reason = arguments.reason

                if (target.id == channel.kord.selfId) {
                    throw DiscordRelayedException("Stop trying to ban yourself.")
                }

                if (target.isBot) {
                    throw DiscordRelayedException("You cannot ban a bot!")
                }



                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Banned User"
                        description = "The user, $user has been banned from $guild for $reason"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class BanCommandArguments : Arguments() {
        val user by user {
            name = "user"
            description = "The user you want to ban"
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why you want to ban the specified user."
            defaultValue = "No reason provided"
        }
    }
}