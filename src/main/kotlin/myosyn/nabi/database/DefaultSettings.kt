package myosyn.nabi.database

import dev.kord.common.entity.Snowflake

fun KClass<ServerConfig>.getDefault(id: Snowflake): ServerConfig {
    return ServerConfig
}