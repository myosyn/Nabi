package live.shuuyu.discordinteraktions.common.requests.managers

import dev.kord.common.entity.*
import dev.kord.common.entity.optional.Optional
import dev.kord.common.entity.optional.coerceToMissing
import dev.kord.common.entity.optional.optional
import dev.kord.core.Kord
import dev.kord.rest.builder.interaction.ModalBuilder
import dev.kord.rest.json.request.InteractionApplicationCommandCallbackData
import dev.kord.rest.json.request.InteractionResponseCreateRequest
import live.shuuyu.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import live.shuuyu.discordinteraktions.common.builder.message.modify.InteractionOrFollowupMessageModifyBuilder
import live.shuuyu.discordinteraktions.common.entities.messages.EditableMessage
import live.shuuyu.discordinteraktions.common.requests.InteractionRequestState
import live.shuuyu.discordinteraktions.common.requests.RequestBridge
import live.shuuyu.discordinteraktions.platforms.kord.entities.messages.KordOriginalInteractionEphemeralMessage
import live.shuuyu.discordinteraktions.platforms.kord.entities.messages.KordOriginalInteractionPublicMessage
import mu.KotlinLogging

/**
 * On this request manager we'll handle the requests
 * by directly interacting with the Discord Rest API.
 *
 * @param rest The application rest client
 * @param applicationId The bot's application ID
 * @param interactionToken The request's token
 * @param request The Discord Interaction request
 */
class InitialHttpRequestManager(
    bridge: RequestBridge,
    val kord: Kord,
    val applicationId: Snowflake,
    val interactionId: Snowflake,
    val interactionToken: String
) : RequestManager(bridge) {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    init {
        require(bridge.state.value == InteractionRequestState.NOT_REPLIED_YET) { "HttpRequestManager should be in the NOT_REPLIED_YET state!" }
    }

    override suspend fun deferChannelMessage() {
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            InteractionResponseCreateRequest(
                InteractionResponseType.DeferredChannelMessageWithSource,
                InteractionApplicationCommandCallbackData().optional()
            )
        )

        bridge.state.value = InteractionRequestState.DEFERRED_CHANNEL_MESSAGE

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun deferChannelMessageEphemerally() {
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            InteractionResponseCreateRequest(
                InteractionResponseType.DeferredChannelMessageWithSource,
                InteractionApplicationCommandCallbackData(
                    flags = MessageFlags {
                        +MessageFlag.Ephemeral
                    }.optional()
                ).optional()
            )
        )

        bridge.state.value = InteractionRequestState.DEFERRED_CHANNEL_MESSAGE

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun sendPublicMessage(message: InteractionOrFollowupMessageCreateBuilder): EditableMessage {
        // *Technically* we can respond to the initial interaction via HTTP too
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            message.toInteractionMessageResponseCreateBuilder().toRequest()
        )

        bridge.state.value = InteractionRequestState.ALREADY_REPLIED

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )

        return KordOriginalInteractionPublicMessage(
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun sendEphemeralMessage(message: InteractionOrFollowupMessageCreateBuilder): EditableMessage {
        // *Technically* we can respond to the initial interaction via HTTP too
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            message.toInteractionMessageResponseCreateBuilder().toRequest()
        )

        bridge.state.value = InteractionRequestState.ALREADY_REPLIED

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )

        return KordOriginalInteractionEphemeralMessage(
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun deferUpdateMessage() {
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            InteractionResponseCreateRequest(
                InteractionResponseType.DeferredUpdateMessage,
                InteractionApplicationCommandCallbackData().optional()
            )
        )

        bridge.state.value = InteractionRequestState.DEFERRED_UPDATE_MESSAGE

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun updateMessage(message: InteractionOrFollowupMessageModifyBuilder): EditableMessage {
        kord.rest.interaction.createInteractionResponse(
            interactionId,
            interactionToken,
            InteractionResponseCreateRequest(
                type = InteractionResponseType.UpdateMessage,
                data = Optional(
                    InteractionApplicationCommandCallbackData(
                        content = Optional(message.content).coerceToMissing(),
                        embeds = message.embeds?.map { it.toRequest() }.optional().coerceToMissing(),
                        allowedMentions = Optional(message.allowedMentions?.build()).coerceToMissing(),
                        components = message.components?.map { it.build() }.optional().coerceToMissing(),
                        flags = MessageFlags {}.optional()
                    )
                )
            )
        )

        bridge.state.value = InteractionRequestState.ALREADY_REPLIED

        bridge.manager = HttpRequestManager(
            bridge,
            kord,
            applicationId,
            interactionToken
        )

        return KordOriginalInteractionPublicMessage(
            kord,
            applicationId,
            interactionToken
        )
    }

    override suspend fun sendStringAutocomplete(list: List<Choice<String>>) {
        kord.rest.interaction.createAutoCompleteInteractionResponse(
            interactionId,
            interactionToken,
            DiscordAutoComplete(list)
        )
    }

    override suspend fun sendIntegerAutocomplete(list: List<Choice<Long>>) {
        kord.rest.interaction.createAutoCompleteInteractionResponse(
            interactionId,
            interactionToken,
            DiscordAutoComplete(list)
        )
    }

    override suspend fun sendNumberAutocomplete(list: List<Choice<Double>>) {
        kord.rest.interaction.createAutoCompleteInteractionResponse(
            interactionId,
            interactionToken,
            DiscordAutoComplete(list)
        )
    }

    override suspend fun sendModal(title: String, customId: String, builder: ModalBuilder.() -> Unit) {
        kord.rest.interaction.createModalInteractionResponse(
            interactionId,
            interactionToken,
            title,
            customId,
            builder
        )
    }
}