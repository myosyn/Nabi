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
import dev.myosyn.nabi.ColorUtils.PUNISHMENT_COLOR
import dev.myosyn.nabi.user.UserDm.dmUser
import kotlinx.datetime.Clock

class BanCommand : Extension() {

    override val name: String = "ban"

    override suspend fun setup() {

        publicSlashCommand(::BanCommandArguments) {
            name = "ban"
            description = "Bans the specified user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val publicBanTarget = arguments.user
                val publicBanReason = arguments.reason

                val userDm = dmUser(
                    publicBanTarget,
                    "You've been banned",
                    "You've been banned from ${guild?.fetchGuild()?.name} for $publicBanReason",
                    PUNISHMENT_COLOR
                )

                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Banned User"
                        description = "The user, $user, has been banned for $publicBanReason"
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
                val privateBanTarget = arguments.user
                val privateBanReason = arguments.reason

                val userDm = dmUser (
                    privateBanTarget,
                    "You've been banned",
                    "You've been banned from ${guild?.fetchGuild()?.name} for $privateBanReason",
                    PUNISHMENT_COLOR
                )

                respond {
                    embed {
                        color = Color(221,237,255)
                        title = "Banned User"
                        description = "The user, $user has been banned from $guild for $privateBanReason"
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