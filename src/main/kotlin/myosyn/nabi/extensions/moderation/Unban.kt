package myosyn.nabi.extensions.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.cache.api.data.description
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior
import dev.kord.core.supplier.EntitySupplyStrategy
import myosyn.nabi.i18n

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
                val actionLog = guild?.getChannel() as GuildMessageChannelBehavior
                val userArgs = arguments.userArgs

                guild?.unban(userArgs.id)
            }
        }
    }

    inner class UnbanArguments : Arguments() {
        val userArgs by user{
            name = "id"
            description = "The user's ID you want to unban"
        }
        val reason by optionalString {
            name = "reason"
            description = "Reason for why you are unbanning said user."
        }
    }
}