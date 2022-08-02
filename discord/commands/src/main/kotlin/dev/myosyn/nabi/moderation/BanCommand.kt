package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingInt
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.ban
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.DEFAULT_COLOR
import dev.myosyn.nabi.user.UserDm.dmUser

class BanCommand : Extension() {
    override val name: String = "ban"

    override suspend fun setup() {
        publicSlashCommand(::BanCommandArguments) {
            name = "ban"
            description = "Bans a user from the guild"

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val target = arguments.user.asUser()
                val providedReasons = arguments.reason

                guild?.withStrategy(EntitySupplyStrategy.rest)?.ban(target.id) {
                    reason = providedReasons
                    deleteMessagesDays = arguments.deleteMessage
                }

                val dmTarget = dmUser (
                    target,
                    "You've Been Banned",
                    "You've been banned from $guild for $providedReasons",
                    DEFAULT_COLOR,
                )

                respond {
                    embed {
                        title = "Banned User"
                        description = "The user, $target, was banned for $providedReasons."
                        color = DEFAULT_COLOR
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
        val deleteMessage by defaultingInt {
            name = "int"
            description = "The number of days of messages you want to delete"
            defaultValue = 0
            validate {
                if (value < 0) {
                    throw DiscordRelayedException("You cannot delete less than 0 days worth of messages!")
                }
                if (value > 7) {
                    throw DiscordRelayedException("You cannot delete more than 7 days worth of messages!")
                }
            }
        }
    }
}
