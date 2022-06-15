package dev.myosyn.nabi

import dev.kord.common.entity.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GuildConstants(
    val GuildOwner: Snowflake,
    val guildId: Snowflake,
    val moderationLogging: Snowflake?,
    val messageChangeLog: Snowflake?,
    val WelcomeLogging: Snowflake?,
    val memberLeaveChannel: Snowflake?,
)