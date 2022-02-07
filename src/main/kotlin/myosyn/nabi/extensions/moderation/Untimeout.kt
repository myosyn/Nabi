package myosyn.nabi.extensions.commands.moderation

import com.kotlindiscord.kord.extensions.DISCORD_BLURPLE
import com.kotlindiscord.kord.extensions.DISCORD_RED
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.types.respondEphemeral
import com.kotlindiscord.kord.extensions.utils.dm
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed

class Untimeout : Extension() {
    override val name = "untimeout"

    override suspend fun setup() {
        publicSlashCommand(::UntimeoutArguments) {
            name = "untimeout"
            description = "Removes the timeout from someone."
            check {
                hasPermission(Permission.MuteMembers)
                requireBotPermissions(Permission.MuteMembers)
            }

            action {
                val member = guild!!.getMemberOrNull(arguments.user.id)

                if (member == null) {
                    respond {
                        embed {
                            color = DISCORD_RED
                            title = "Error"
                            description = "You provided an invalid ID or user!"
                        }
                    }
                } else {
                    if (!member.isBot)  {
                        member.dm{
                            embed {
                                color = DISCORD_BLURPLE
                                title = "Untimeout"
                                description = "You have been untimeout by ${user.asUser().username} with the reason ${arguments.reason}"
                            }
                        }

                    }
                }
            }
        }
    }
    inner class UntimeoutArguments : Arguments() {
        val user by user(){
            name = "user"
        }

    }
}