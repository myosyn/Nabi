package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.cache.api.data.description
import dev.kord.common.entity.Permission

class Unban : Extension() {
    override val name = "unban"

    override suspend fun setup() {
        publicSlashCommand(::UnbanArguments) {
            name = "Unban"
            description = "Unbans a user."
            requireBotPermissions(Permission.BanMembers)

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
            }

            action {
                respond {

                }
            }

        }
    }

    inner class UnbanArguments : Arguments() {
        val userArguments by user{
            name =
        }
        val reason by optionalString {
            name = "reason"
            description = "Reason for why you are unbanning said user."
        }
    }
}