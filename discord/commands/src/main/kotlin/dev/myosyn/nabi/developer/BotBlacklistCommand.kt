package dev.myosyn.nabi.developer

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond

class BotBlacklistCommand : Extension() {
    override val name: String = "BotBlacklist"

    override suspend fun setup() {
        publicSlashCommand(::BotBlacklistArguments) {
            name = "BotBlacklist"
            description = "Blacklists a user from using Nabi. This is an Owner only command"

            check {
                anyGuild()
            }

            action {
                val target = arguments.user

                respond  {

                }
            }
        }
    }

    inner class BotBlacklistArguments : Arguments() {
        val user by user {
            name = "user"
            description = "User that you want to blacklist from using me"
        }

        val reason by defaultingString {
            name = "reason"
            description = "The reason why you want this us"
            defaultValue = "No reason provided"
        }
    }
}