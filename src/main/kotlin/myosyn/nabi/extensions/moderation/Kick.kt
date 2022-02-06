@file:OptIn(ExperimentalTime::class)

package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.annotations.ExtensionDSL
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import kotlin.time.ExperimentalTime

@ExtensionDSL
class Kick : Extension() {
    override val name = "kick"

    override suspend fun setup() {
        publicSlashCommand(::KickArguments) {
            name = "Kick"
            description = "Kicks a specified user from your server"
            requireBotPermissions(Permission.KickMembers)

            check {
                anyGuild()
                hasPermission(Permission.KickMembers)
            }

            action {
                val user = arguments.userArguments

            }
        }
    }

    inner class KickArguments : Arguments() {
        val userArguments by user{
            name = "User"
            description = "User to kick from the server"
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why the user was kicked from the server"
        }
    }
}