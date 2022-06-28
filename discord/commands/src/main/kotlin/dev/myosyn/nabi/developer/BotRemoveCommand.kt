package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class BotRemoveCommand : Extension() {
    override val name: String = "botremove"

    override suspend fun setup() {
        publicSlashCommand(::BotRemoveArguments) {
            name = "remove"
            description = "Removes Nabi from a specific server"

            check {
                anyGuild()
            }

            action {
                val targetGuild = arguments.badguild
            }
        }
    }

    inner class BotRemoveArguments: Arguments() {
        val badguild by string {
            name = "guild"
            description = "The guild you want to remove Nabi from"
            validate {

            }
        }
    }
}