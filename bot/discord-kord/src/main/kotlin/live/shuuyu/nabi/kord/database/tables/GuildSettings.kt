package live.shuuyu.nabi.kord.database.tables

import org.jetbrains.exposed.sql.Table

object GuildSettings: Table("guild_settings") {
    val guildOwner = long("guild_owner") // This can NOT be nullable under any circumstances 
}