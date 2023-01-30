package live.shuuyu.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class BanCommand : Extension() {
    override val name: String = "ban"


    override suspend fun setup() {
        publicSlashCommand(::BanArguments) {
            name = this@BanCommand.name
            description = "Bans the requested user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
            }

            action {

            }
        }
    }
}

class BanArguments : Arguments() {
    val user by user {
        name = "user"
        description = "The user you want to ban from the server."
    }

    val reason by defaultingString {
        name = "reason"
        description = "The reason why you banned this user."
    }
}