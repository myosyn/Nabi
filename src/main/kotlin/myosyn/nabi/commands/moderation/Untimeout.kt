package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class Untimeout : Extension() {
    override val name = "untimeout"

    override suspend fun setup() {
        publicSlashCommand(::Untimeout) {
            name = "untimeout"
            description = "Removes the timeout from someone."
            check {
                hasPermission(Permission.MuteMembers)
                requireBotPermissions(Permission.MuteMembers)
            }

            action {
                val userArg = arguments.userArguments
            }
        }
    }

    class UntimeoutArgs : Arguments() {
        val userArgument by user("timeout")
    }
}