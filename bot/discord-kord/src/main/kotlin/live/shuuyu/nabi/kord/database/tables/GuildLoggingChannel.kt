package live.shuuyu.nabi.kord.database.tables

import org.jetbrains.exposed.sql.Table

object GuildLoggingChannel : Table("logging") {
    val moderation = long("moderation").nullable()
    val join = long("join").nullable()
    val leave = long("leave").nullable()
}