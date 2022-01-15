package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Unban : Extension() {
    override val name = "unban"

    override suspend fun setup() {
        publicSlashCommand(::Unban) {
            name = "Unban"
            description = "Unbans a user."
        }
    }

    inner class UnbanArgs : Arguments() {
        val userArguments by user("unbanUserId", "Person Unbanned")
        val reason by defaultingString("reason", "The reason why they were unbanned", "No reason provided.")
    }
}