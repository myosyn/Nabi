package dev.myosyn.nabi.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.ephemeralSubCommand
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import dev.kord.rest.builder.message.create.embed
import kotlin.time.Duration

/*
DEPRECATE THIS LATER IN 1.0.0 PRE-3, THIS IS SO USELESS
LIKE WHY DID I MAKE THIS IN THE FIRST PLACE

I SWEAR IF I DO NOT GET RID OF THIS I WILL CRY INSIDE
 */

class RemoveSlowModeCommand : Extension() {
    override val name: String = "RemoveSlowMode"

    override suspend fun setup() {
        publicSlashCommand {
            name = "removeslowmode"
            description = "Removes slow mode from a channel."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

            publicSubCommand(::RemoveSlowModeArguments) {
                name = "public"
                description = "Makes the entire command public for people to see."

                action {
                    val channel = channel.asChannel() as TextChannel
                    val reason = arguments.reason

                    channel.edit {
                        rateLimitPerUser = Duration.INFINITE
                    }

                    respond {
                        embed {
                            title = "Channel Unlocked"
                            description = "The channel, $channel, has been unlocked for $reason."
                        }
                    }
                }
            }

            ephemeralSubCommand {
                name = "ephemeral"
                description = "Makes the entire command ephemeral, so only you can see it."

                action {
                    val channel = channel.asChannel() as TextChannel
                    val reason = arguments

                    channel.edit {
                        rateLimitPerUser = Duration.ZERO
                    }

                    respond {
                        embed {
                            title = "Channel Unlocked"
                            description = "The channel, $channel, has been unlocked for $reason."
                        }
                    }
                }
            }
        }
    }
    inner class RemoveSlowModeArguments : Arguments() {
        val reason by defaultingString {
            name = "reason"
            description = "The reason for why the channel was unlocked"
            defaultValue = "No reason provided"
        }
    }
}