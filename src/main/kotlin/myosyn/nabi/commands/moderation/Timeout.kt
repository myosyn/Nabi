package myosyn.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand

class Timeout : Extension() {
    override val name = "timeout"

    override suspend fun setup() {
        ephemeralSlashCommand(::Timeout) {
            name = "timeout"
            description = "Times out a player. Functions similarly to a mute, but without the role."


        }
    }
}