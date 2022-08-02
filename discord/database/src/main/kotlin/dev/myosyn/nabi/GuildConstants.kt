package dev.myosyn.nabi

import org.jetbrains.exposed.sql.Table

object GuildConstants : Table("guildConstants") {
    val guildOwner = uuid("id")
}