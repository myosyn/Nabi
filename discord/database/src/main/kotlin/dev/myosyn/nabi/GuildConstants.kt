package dev.myosyn.nabi

import dev.kord.common.entity.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GuildConstants(
    val GuildOwner: Snowflake?,
    val GuildId: Snowflake?,
    val ModerationLogging: Snowflake? = null,
    val WelcomeLogging: Snowflake? = null,
    val LeavingLogging: Snowflake? = null,
)