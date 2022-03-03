package myosyn.nabi.extensions.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.Channel

class UnlockChannel : Extension() {
    override val name: String = "unlockchannel"

    override suspend fun setup() {
        publicSlashCommand(::UnlockChannelArguments) {
            name = "UnlockChannel"
            description = "Unlocks a locked channel."
            requireBotPermissions(Permission.ManageChannels)

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
            }

            action {
                val channel: Channel = if (arguments.channel != null) {
                    arguments.channel!!
                } else {
                    channel.asChannel()
                }
            }
        }
    }
    inner class UnlockChannelArguments : Arguments() {
        val channel by optionalChannel {
            name =
        }
    }
}