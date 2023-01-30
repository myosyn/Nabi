package live.shuuyu.nabi.database.tables

import org.jetbrains.exposed.sql.Table

object Blacklist : Table("blacklist") {
    val userId = long("user").index()
    val reason = text("reason")
}