package live.shuuyu.nabi.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

class GuildCommand : Extension() {
    override val name: String = "guild"

    override suspend fun setup() {
        publicSlashCommand {
            name = this@GuildCommand.name
            description = "Looks up information in the given guild."

            // I would definitely allow looking up the guild you're currently in in your dms
            allowInDms = false

            check {
                anyGuild()
            }

            action {
                val target = this.guild?.asGuild()

                respond {
                    embed {

                    }
                }
            }
        }
    }
}