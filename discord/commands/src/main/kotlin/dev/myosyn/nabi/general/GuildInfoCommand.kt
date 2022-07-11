package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalSnowflake
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

class GuildInfoCommand : Extension() {
    override val name: String = "GuildInfo"

    override suspend fun setup() {
        publicSlashCommand(::GuildInfoArguments) {
            name = "guildInfo"
            description = "Shows information about the given Discord Server. Defaults to the server you're already in."

            check {
                anyGuild()
            }

            action {
                val channel = arguments.guildArg ?: this.guild?.asGuild()

                respond {
                    embed {
                        title = "Guild Information"
                        field {
                            name = "Guild statistics"
                        }
                        color = DEFAULT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class GuildInfoArguments : Arguments() {
        val guildArg by optionalSnowflake {
            name = "guild"
            description = "The guild that you want to look up"
            validate {

            }
        }
    }
}