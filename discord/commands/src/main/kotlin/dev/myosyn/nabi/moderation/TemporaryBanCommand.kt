package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions

class TemporaryBanCommand : Extension() {
    override val name: String = "temporaryban"

    override suspend fun setup() {
        publicSlashCommand(::TemporaryBanArguments) {
            name = "TemporaryBan"
            description = "Temporarily bans someone."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {

            }
        }
        ephemeralSlashCommand(::TemporaryBanArguments) {
            name = "SilentTemporaryBan"
            description = "Silently temporarily bans someone."

            check {
                anyGuild()
                Permissions(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }
            action {

            }
        }
    }
    inner class TemporaryBanArguments : Arguments() {
        val user by user {
            name = "user"
            description = "Specifies the user that you want to ban."
        }


    }
}