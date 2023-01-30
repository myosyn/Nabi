package live.shuuyu.nabi.database.tables

import org.jetbrains.exposed.sql.Table

object LoggingChannels : Table("logging_channels") {
    val guildId = long("guildId").index()
    val channelId = long("channelId").index()
}