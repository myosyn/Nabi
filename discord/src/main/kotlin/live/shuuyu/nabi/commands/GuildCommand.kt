package live.shuuyu.nabi.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class GuildCommand : Extension() {
    override val name: String = "guild"

    override suspend fun setup() {
        publicSlashCommand {
            name = this@GuildCommand.name
            description = "Looks up information in the given guild."

            check {
                anyGuild()
            }

            action {
                val target = this.guild?.asGuild()


            }
        }
    }
}