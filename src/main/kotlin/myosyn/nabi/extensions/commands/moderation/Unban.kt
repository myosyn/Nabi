package myosyn.nabi.extensions.commands.moderation

import bot.configureAuthor
import bot.i18n
import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.cache.api.data.description
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Snowflake
import dev.kord.core.supplier.EntitySupplyStrategy

class Unban : Extension() {
    override val name = "unban"

    override suspend fun setup() {
        publicSlashCommand(::Unban) {
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

    inner class UnbanArgs : Arguments() {
        val userArguments by user("unbanUserId", "Person Unbanned")
        val reason by optionalString {
            name = "reason"
            description = "Reason for why you are unbanning said user."
        }
    }
}