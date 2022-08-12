package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.snowflake
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.SUCCESS_COLOR
import kotlinx.datetime.Clock

class UnbanCommand : Extension() {
    override val name: String = "unban"

    override suspend fun setup() {
        publicSlashCommand(::UnbanArguments) {
            name = "unban"
            description = "Unbans a user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val target = arguments.id
                val targetReason = arguments.reason

                guild?.withStrategy(EntitySupplyStrategy.rest)?.unban(target, targetReason)

                respond {
                    embed {
                        title = "Unbanned User"
                        description = "The user, $target, has been unbanned from $guild for $targetReason"
                        color = SUCCESS_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class UnbanArguments : Arguments() {
        val id by snowflake {
            name = "User ID"
            description = "The User's ID you want to unban."
        }
        val reason by defaultingString {
            name = "Reason"
            description = "The reason why you want to unban the person."
            defaultValue = "No reason provided."
        }
    }
}