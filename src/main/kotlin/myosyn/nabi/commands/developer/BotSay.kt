package myosyn.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class BotSay : Extension() {
    override val name = "botsay"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotSay) {
            name = "BotSay"
            description = "The bot will say whatever you type in. This is only limited to owners due to the likely chance for one to abuse this command."

            allowUser(Snowflake(OWNER_ID))
        }
    }
}