package live.shuuyu.nabi.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.ChannelType
import dev.kord.rest.builder.message.create.embed

class ChannelCommand : Extension() {
    override val name: String = "channel"
    override val bundle: String = "nabi.ChannelCommand"

    override suspend fun setup() {
        publicSlashCommand(::ChannelArguments) {
            name = this@ChannelCommand.name
            description = "Provides information of a specified channel in this current guild."

            allowInDms = false

            check {
                anyGuild()
            }

            action {
                val target = arguments.channel ?: this.channel.asChannel()
                val name = target.kord.rest

                respond {
                    embed {
                        title = "$name's information"

                        when (target.type) {

                            ChannelType.GuildText -> {
                                field {
                                    value = translate("embed.TextChannel")
                                }
                            }

                            ChannelType.PublicGuildThread, ChannelType.PrivateThread -> {
                                field {
                                    value = "Channel Type: Threads"
                                }
                            }

                            ChannelType.GuildVoice -> {
                                field {
                                    value = "Channel Type: Voice Channel"
                                }
                            }

                            else -> {}
                        }
                    }
                }
            }
        }
    }
}

class ChannelArguments : Arguments() {
    val channel by optionalChannel {
        name = "channel"
        description = "The channel you want to look up."
    }
}