package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class TemporaryBanCommand : Extension() {
    override val name: String = "temporaryban"

    override suspend fun setup() {
        publicSlashCommand(::TemporaryBanArguments) {
            name = "TemporaryBan"
            description = "Temporarily bans someone."

            check {

            }

            action {  }
        }
    }
    inner class TemporaryBanArguments : Arguments() {
        val user by user {
            name = "user"
            description = "Specifies the user that you want to ban."
        }


    }
}