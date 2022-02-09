package myosyn.nabi.extensions.developer

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.*
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.channel.MessageChannel
import myosyn.nabi.utils.OWNER_ID

class BotSay : Extension() {
    override val name = "botsay"

    override suspend fun setup() {
        ephemeralSlashCommand(::BotSayArguments) {
            name = "BotSay"
            description = "The bot will say whatever you type in. This is only limited to owners due to the likely chance for one to abuse this command."

            allowUser(Snowflake(OWNER_ID))

            action {
                val channel: MessageChannel = if (arguments.channel == null) {
                    channel.asChannel()
                } else {
                    arguments.channel!!.asChannel() as MessageChannel
                }

                channel.createMessage {arguments.message}
            }
        }
    }

    inner class BotSayArguments : Arguments() {
        val channel by optionalChannel {
            name = "channel"
            description = "The channel you want to send this to. Do not include this if you want to send this in the same channel."
        }

        val message by string{
            name = "message"
            description = "The bot will say what you typed in here."
        }
    }
}