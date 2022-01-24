package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Argument
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

@Suppress("DuplicatedCode")
class Ban : Extension() {
    override val name: String = "ban"

    override suspend fun setup() {
        publicSlashCommand(::BanArguments) {
            name = "ban"
            description = "Throws the clowns out of the circus."
            requireBotPermissions(Permission.BanMembers)

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
            }

            action {
                val providedReason = arguments.reason ?:
                val author = user.asUser()

                val dm = ResponseHelper.userDMEmbed(
                    userArg,
                    ""
                )


            }
        }
    }
    inner class BanArguments : Arguments() {
        val target by user {
            name = "User"
            description = "User to ban from the server"
        }

        val reason by optionalString {
            name = "Reason"
            description = "Why the user was banned from the server"
        }
    }
}


