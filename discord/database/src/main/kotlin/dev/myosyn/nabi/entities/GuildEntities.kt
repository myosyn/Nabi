package dev.myosyn.nabi.entities

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.User

data class GuildEntities(
    val GuildId: MutableMap<Snowflake, User>,
    val GuildOwner: MutableMap<Snowflake, User>
)