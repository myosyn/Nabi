package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class SetWelcomeChannelCommand : Extension() {
    override val name: String = "SetWelcomeChannel"

    override suspend fun setup() {
        publicSlashCommand(::SetWelcomeChannelArguments ) {
            name = "SetWelcomeChannel"
            description = "Sets the welcome channel."

            check {

            }
        }
    }

    inner class SetWelcomeChannelArguments : Arguments() {
        val channel by optionalChannel {
            name = "Channel"
            description = "Sets the specified channel to be the welcoming channel."
        }
    }
}