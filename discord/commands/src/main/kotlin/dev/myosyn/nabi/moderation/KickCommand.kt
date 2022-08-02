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
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.PUNISHMENT_COLOR
import dev.myosyn.nabi.user.UserDm.dmUser
import kotlinx.datetime.Clock

class KickCommand: Extension() {
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

                guild?.withStrategy(EntitySupplyStrategy.rest)?.kick(target.id, targetReason)

                val dmUser = dmUser (
                    target,
                    "Kicked from Server",
                    "You have been kicked from $guild for $targetReason. You may join back if you pleased.",
                    PUNISHMENT_COLOR
                )

                respond {
                    embed {
                        title = "Kicked User"
                        description = "The user, $target, was kicked from $guild for $targetReason."
                        color = PUNISHMENT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class KickArguments: Arguments() {
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