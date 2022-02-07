package myosyn.nabi.extensions.logging

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class JoinLeaveLogging : Extension() {
    override val name = "joinleavelogging"

    override suspend fun setup() {
        publicSlashCommand(::JoinLeaveLoggingArguments) {
            name = "JoinLeaveLogging"
            description = "Sets the channel for leaving and joining."
            requireBotPermissions(Permission.Administrator)

            check{
                anyGuild()
                hasPermission(Permission.Administrator)
            }
        }
    }
}