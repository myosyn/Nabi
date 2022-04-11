package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class BanCommand : Extension() {
    override val name = "ban"

    override suspend fun setup() {
        publicSlashCommand(::BanCommandArguments) {
            name = "Ban"
            description = "Bans the specified user from the server."

            action {

            }
        }
    }
    inner class BanCommandArguments : Arguments() {
        val target by user {
            name = "user"
            description = "The user you want to ban"
        }
        val reason by defaultingString {
            name = "reason"
            description = "The reason why you want to ban the specified user."
            defaultValue = "No reason provided"
        }
    }
}