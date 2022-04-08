package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand

class InfoCommand : Extension() {
    override val name: String = "info"

    override suspend fun setup() {
        ephemeralSlashCommand {
            name = "Info"
            description = "Shows the info of the bot."
        }
    }
}