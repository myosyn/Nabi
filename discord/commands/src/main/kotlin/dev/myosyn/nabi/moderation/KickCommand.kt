package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.myosyn.nabi.ColorUtils.PUNISHMENT_COLOR
import dev.myosyn.nabi.user.UserDm.dmUser
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand


class KickCommand : Extension() {
    override val name: String = "Kick"

    override suspend fun setup() {
        publicSlashCommand(::KickArguments) {
            name = "kick"
            description = "Kicks a member from the guild"

            check {
                anyGuild()
                hasPermission(Permission.KickMembers)
                requireBotPermissions(Permission.KickMembers)
            }

            action {
                val target = arguments.user.asUser()
                val targetReason = arguments.reason

                guild?.kick(target.id)

                val dmUser = dmUser (
                    target,
                    "You've Been Banned",
                    "You have been banned from ",
                    PUNISHMENT_COLOR
                )


                respond {

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