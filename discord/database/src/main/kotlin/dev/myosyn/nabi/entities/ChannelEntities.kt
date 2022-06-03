package dev.myosyn.nabi.entities

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.channel.Channel
import kotlinx.serialization.Serializable

@Serializable
data class ChannelEntities(
    val ModerationLoggingChannel: MutableMap<Snowflake, Channel>,
    val WelcomeLoggingChannel: MutableMap<Snowflake, Channel>,
    val LeavingLoggingChannel: MutableMap<Snowflake, Channel>,
    val PhishingLoggingChannel: MutableMap<Snowflake, Channel>
)