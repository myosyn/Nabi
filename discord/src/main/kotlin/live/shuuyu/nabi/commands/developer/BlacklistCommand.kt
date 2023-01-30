package live.shuuyu.nabi.commands.developer

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class BlacklistCommand : Extension() {
    override val name: String = "blacklist"

    override suspend fun setup() {
        publicSlashCommand {
            name = this@BlacklistCommand.name
            description = "Blacklists someone/something from using any Nabi related services."

            publicSubCommand(::BlacklistUserArguments) {
                name = "user"
                description = "Blacklists a user from using any Nabi related services."

                check {

                }

                action {

                }
            }
        }
    }
}

class BlacklistUserArguments : Arguments() {
    val user by user {
        name = "user"
        description = "The user you want to blacklist."
    }

    val reason by optionalString {
        name = "reason"
        description = "The reason why you want to blacklist this user."
    }


}