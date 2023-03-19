package live.shuuyu.discordinteraktions.common.builder.message.create

import dev.kord.rest.builder.message.create.FollowupMessageCreateBuilder
import dev.kord.rest.builder.message.create.InteractionResponseCreateBuilder
import live.shuuyu.discordinteraktions.common.builder.message.MessageBuilder

/**
 * The base builder for creating a new message.
 */
// From Kord
sealed interface MessageCreateBuilder : MessageBuilder {
    /**
     * Whether this message should be played as a text-to-speech message.
     */
    var tts: Boolean?

    fun toFollowupMessageCreateBuilder(): FollowupMessageCreateBuilder
    fun toInteractionMessageResponseCreateBuilder(): InteractionResponseCreateBuilder
}