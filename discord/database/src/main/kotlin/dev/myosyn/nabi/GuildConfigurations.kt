package dev.myosyn.nabi

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@OptIn(ExperimentalUnsignedTypes::class)
object GuildConfigurations : Table("guildConfigurations") {
    val guildId: Column<Long> = long("guild_id")

    val moderationChannelId = ulong("moderationChannelId")
    val suggestionChannelId = ulong("suggestionChannelId")
    val welcomeChannelId = ulong("welcomeChannelId")
    val leaveChannelId = ulong("leaveChannelId")

    override val primaryKey: PrimaryKey = PrimaryKey(guildId)
}