package myosyn.nabi.extensions.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class BotBan : Extension() {
    override val name = "botban"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotBan) {
            name = "BotBan"
            description = "Owner only command. Removes this bot from the server it is in."

            allowUser(Snowflake(OWNER_ID))


        }
    }
}