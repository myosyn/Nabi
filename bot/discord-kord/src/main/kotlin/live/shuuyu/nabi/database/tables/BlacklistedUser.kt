package live.shuuyu.nabi.database.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object BlacklistedUser : LongIdTable("Blacklisted") {
    val user = long("user_id")
    val reason = text("reason")
}