package dev.myosyn.nabi.entities

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.channel.Channel

// The reason why we have the = null is because if there is no value, we just cancel it because why not.
data class ChannelEntities(
    val ModerationLoggingChannel: MutableMap<Snowflake, Channel>? = null,
    val WelcomeLoggingChannel: MutableMap<Snowflake, Channel>? = null,
    val LeavingLoggingChannel: MutableMap<Snowflake, Channel>? = null,
    val PhishingLoggingChannel: MutableMap<Snowflake, Channel>? = null
)