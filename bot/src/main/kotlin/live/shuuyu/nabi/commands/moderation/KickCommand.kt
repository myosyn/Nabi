package live.shuuyu.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.create.UserMessageCreateBuilder
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class KickCommand : Extension() {
    override val name: String = "kick"
    override suspend fun setup() {
        publicSlashCommand {
            name = this@KickCommand.name
            description = "Kicks the specified user from the guild."

            check {

            }

            action {
                try {

                } catch (_: DiscordRelayedException) {

                }
            }
        }
    }

    private fun createDirectMessage(
        guild: Guild,
        user: User,
        reason: String
    ): UserMessageCreateBuilder.() -> (Unit) = {
        embed {
            timestamp = Clock.System.now()
        }
    }
}

class KickArguments : Arguments() {
    val user by user {
        name = "user"
        description = "The user you want to kick."
    }
    val reason by defaultingString {
        name = "reason"
        description = "The reason why this user is being kicked."
    }
}