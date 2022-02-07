package myosyn.nabi.extensions.developer

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import myosyn.nabi.utils.OWNER_ID

class BotBan : Extension() {
    override val name = "botban"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotBanArguments) {
            name = "BotBan"
            description = "Owner only command. Removes this bot from the server it is in."

            allowUser(Snowflake(OWNER_ID))

            action {


            }
        }
    }

    inner class BotBanArguments : Arguments() {
        val
    }
}