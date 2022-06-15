package dev.myosyn.nabi.embeds

import dev.kord.common.Color
import dev.kord.rest.builder.message.EmbedBuilder
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

object EmbedBuilder {
    suspend fun EmbedBuilder.buildEmbedforModeration(embedName: String?, embedDescription: String?, color: Color) {
        title = embedName
        description = embedDescription
        timestamp = Clock.System.now()
    }
}