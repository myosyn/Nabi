package dev.myosyn.nabi.setchannels

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.checks.interactionFor
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class SetLeaveChannelCommand : Extension() {
    override val name: String = "SetLeaveChannel"

    override suspend fun setup() {
        publicSlashCommand(::SetLeaveChannelArguments) {
            name = "SetLeaveChannel"
            description = "Sets the specified channel as the leaving channel."

            check {
                anyGuild()
                hasPermission(Permission.Administrator)
                requireBotPermissions(Permission.Administrator)
            }

            action {

            }
        }
    }
    inner class SetLeaveChannelArguments : Arguments() {
        val channel by optionalChannel {
            name = "channel"
            description = ""
        }
    }
}