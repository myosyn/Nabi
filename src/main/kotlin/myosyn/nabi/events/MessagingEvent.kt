package myosyn.nabi.events

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.event
import dev.kord.core.behavior.channel.GuildMessageChannelBehavior
import dev.kord.core.event.message.MessageDeleteEvent

class MessagingEvent : Extension() {
    override val name = "messagingevent"

    private val LOG_FILE_EXTENSION = setOf("log", "gz", "txt")

    override suspend fun setup() {
        event<MessageDeleteEvent> {
            action {
                if (event.message?.author.id == kord.selfId) return@action

                val actionLog = event.guild?.getChannelOrNull() as GuildMessageChannelBehavior
            }
        }
    }
}