package live.shuuyu.discordinteraktions.common.entities.messages

import live.shuuyu.discordinteraktions.common.builder.message.modify.InteractionOrFollowupMessageModifyBuilder

interface EditableMessage {
    suspend fun editMessage(message: InteractionOrFollowupMessageModifyBuilder): EditableMessage
}

// This isn't in the interface because we want this to be inline, allowing users to use suspendable functions within the builder
suspend inline fun EditableMessage.editMessage(block: InteractionOrFollowupMessageModifyBuilder.() -> (Unit)) =
    editMessage(InteractionOrFollowupMessageModifyBuilder().apply(block))