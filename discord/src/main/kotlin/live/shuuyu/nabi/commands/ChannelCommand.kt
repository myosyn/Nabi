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

    override suspend fun setup() {
        publicSlashCommand {
            name = this@ChannelCommand.name
            description = "Provides information of a specified channel in this current guild."

            check {
                anyGuild()
            }

            action {
                val channel = this.channel.asChannel()
                val name = channel.data.name

                respond {
                    embed {
                        when (channel.type) {

                            ChannelType.GuildText -> {
                                field {

                                }
                            }

                            ChannelType.PublicGuildThread, ChannelType.PrivateThread -> {
                                field {

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