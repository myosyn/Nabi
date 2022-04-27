package dev.myosyn.nabi

import dev.kord.common.entity.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GuildConstants(
    val GuildId: Snowflake,
    val ModerationLogging: Snowflake,
    val WelcomeLogging: Snowflake,
    val LeavingLogging: Snowflake,
    val GuildOwner: Snowflake,
)