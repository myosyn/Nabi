package live.shuuyu.nabi.kord.database.tables

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.stringLiteral

object BlacklistedUser : Table("blacklist") {
    val user = ulong("user_id")
    val reason = text("reason")
}