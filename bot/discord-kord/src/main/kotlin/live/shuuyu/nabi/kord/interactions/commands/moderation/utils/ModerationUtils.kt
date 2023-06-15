package live.shuuyu.nabi.kord.interactions.commands.moderation.utils

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.User
import dev.kord.rest.json.request.DMCreateRequest
import dev.kord.rest.json.request.MultipartMessageCreateRequest
import dev.kord.rest.request.RestRequestException
import dev.kord.rest.service.RestClient

object ModerationUtils {
    suspend fun sendDirectModerationMessage(
        user: User,
        rest: RestClient,
        creator: MultipartMessageCreateRequest
    ): Boolean {
        return try {
            val channelId = rest.user.createDM(DMCreateRequest(user.id)).id.value.toLong()

            rest.channel.createMessage(Snowflake(channelId), creator)
            true
        } catch (e: RestRequestException) {
            e.printStackTrace()
            false
        }
    }
}