package live.shuuyu.nabi.kord.interactions.commands.moderation.utils

import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.rest.builder.message.create.FollowupMessageCreateBuilder
import dev.kord.rest.builder.message.create.embed

object ModerationUtils {
    fun createModerationEmbed(
        title: String,
        description: String
    ): FollowupMessageCreateBuilder.() -> (Unit) {
        return {
            embed {

            }
        }
    }

    suspend fun checkUserPermissions(user: User, guild: Guild) {
        when {
            guild.isOwner -> {}
        }
    }
}