package live.shuuyu.nabi.kord.database.tables

import org.jetbrains.exposed.dao.id.LongIdTable

object UserSettings: LongIdTable() {
    val blacklist = bool("blacklist").default(false)
    val developer = bool("developer").default(false)
}