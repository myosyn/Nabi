package dev.myosyn.nabi.suggestion

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class SuggestionAcceptCommand : Extension() {
    override val name: String = "SuggestionAccept"

    override suspend fun setup() {
        publicSlashCommand {

        }
    }
    inner class SuggestionAcceptArguments : Arguments() {
        val id by string {
            name = "id"
            description = "The suggestion that you want"
        }
    }
}