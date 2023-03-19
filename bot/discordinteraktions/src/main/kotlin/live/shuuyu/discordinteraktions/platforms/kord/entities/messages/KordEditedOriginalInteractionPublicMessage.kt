package live.shuuyu.discordinteraktions.platforms.kord.entities.messages

import dev.kord.common.entity.DiscordMessage
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import live.shuuyu.discordinteraktions.common.builder.message.modify.InteractionOrFollowupMessageModifyBuilder
import live.shuuyu.discordinteraktions.common.entities.messages.EditableMessage

class KordEditedOriginalInteractionPublicMessage(
    kord: Kord,
    private val applicationId: Snowflake,
    private val interactionToken: String,
    data: DiscordMessage
) : KordPublicMessage(kord, data), EditableMessage {
    override suspend fun editMessage(message: InteractionOrFollowupMessageModifyBuilder): EditableMessage {
        val newMessage = kord.rest.interaction.modifyFollowupMessage(
            applicationId,
            interactionToken,
            this.data.id,
            message.toFollowupMessageModifyBuilder().toRequest()
        )

        return KordEditedOriginalInteractionPublicMessage(
            kord,
            applicationId,
            interactionToken,
            newMessage
        )
    }
}