package live.shuuyu.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.ban
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.create.UserMessageCreateBuilder
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class BanCommand() : Extension() {
    override val name: String = "ban"
    override suspend fun setup() {
        publicSlashCommand(::BanArguments) {
            name = this@BanCommand.name
            description = "Bans a user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
            }

            action {
                val directmessage = try {
                    createDirectMessage(this.guild!!.asGuild(), this.user.asUser(), arguments.reason)
                } catch (_: DiscordRelayedException) {
                    throw DiscordRelayedException("Cannot alert the user of their punishment! Perhaps their direct messages are off?")
                }

                try {
                    guild!!.ban(arguments.user.id) {
                        reason = arguments.reason
                    }
                    successfulBanEmbed(arguments.user, arguments.reason)
                    directmessage
                } catch (_: DiscordRelayedException) {
                    respond {
                        embed {
                            title = "Error"
                            description = "This user cannot be banned! Please check if certain permissions are enabled."
                            timestamp = Clock.System.now()
                        }
                    }
                }
            }
        }
    }

    private fun createDirectMessage(
        guild: Guild,
        punisher: User,
        reason: String
    ): UserMessageCreateBuilder.() -> (Unit) = {
        embed {
            title = "Banned"
            field("You've been banned from **${guild.name}** for **$reason**", false)
            field("Banned by $punisher", false)
            timestamp = Clock.System.now()
        }
    }

    private fun successfulBanEmbed(
        user: User,
        reason: String
    ) {

    }
}

class BanArguments : Arguments() {
    val user by user {
        name = "user"
        description = "The user you want to ban from the server."
    }
    val reason by defaultingString {
        name = "reason"
        description = "The reason why this user is being banned from the server."
        defaultValue = "No reason provided."
    }
}