package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

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
        }
    }
    inner class BanCommandArguments : Arguments() {
        val target by user {
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