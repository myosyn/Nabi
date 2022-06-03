package dev.myosyn.nabi.entities

import dev.kord.common.entity.Snowflake
import kotlinx.serialization.Serializable

@Serializable
data class GuildEntities(
    val GuildId: Snowflake,
    val GuildOwner: Snowflake
)