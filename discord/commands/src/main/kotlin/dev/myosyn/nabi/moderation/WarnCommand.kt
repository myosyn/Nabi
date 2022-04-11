package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class WarnCommand : Extension() {
    override val name: String = "warn"

    override suspend fun setup() {
        publicSlashCommand(::WarnCommandArguments) {

        }
    }
    inner class WarnCommandArguments : Arguments() {

    }
}