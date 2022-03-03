package myosyn.nabi.extensions.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Statistics : Extension() {
    override val name: String = "stats"

    override suspend fun setup() {

        publicSlashCommand {
            name = "stats"
            description = "Shows you the current ram & cpu usage of Nabi"

            check {
                anyGuild()
            }

            action{
                
            }
        }
    }
}