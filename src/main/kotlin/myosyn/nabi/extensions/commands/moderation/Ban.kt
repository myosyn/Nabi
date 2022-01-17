package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.chatCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

@Suppress("DuplicatedCode")
class Ban : Extension() {
    override val name: String = "ban"

    override suspend fun setup() {
        publicSlashCommand(::BanArguments) {
            name = "ban"
            description = "Throws the clowns out of the circus."
            requireBotPermissions(Permission.BanMembers)

            check {
                hasPermission(Permission.BanMembers)
            }

            action {
                val user = arguments.userArguments

            }
    }

    class BanArguments : Arguments() {
        val userArguments by user("banUser", "Person to ban")
        val message by int("messages", "Messages")
        val reasons by defaultingString("reason", "The reason for this ban", "No reason provided.")
    }
}