package myosyn.nabi.extensions.commands.developer

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Snowflake
import myosyn.nabi.utils.OWNER_ID

class BotSay : Extension() {
    override val name = "botsay"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotSayArguments) {
            name = "BotSay"
            description = "The bot will say whatever you type in. This is only limited to owners due to the likely chance for one to abuse this command."

            allowUser(Snowflake(OWNER_ID))

            action {
                respond { content = arguments.message }
            }
        }
    }

    inner class BotSayArguments : Arguments() {
        val message by string{
            name = "message"
            description = "The bot will say what you typed."
        }
    }
}