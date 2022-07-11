package dev.myosyn.nabi.myosyn

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

class GetOffOfFeatherClient : Extension() {
    override val name: String = "GetOffOfFeatherClient"

    override suspend fun setup() {
        publicSlashCommand {
            name = "feather"
            description = "Stop using a client that has more bugs and issues than hunt down the freeman"

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        color = DEFAULT_COLOR
                        title = "Feather Client Error"
                        description = "You're currently using Feather Client, which is unsupported by us." +
                            "It will break many features in this mod, and it is obfuscated, making it hard to support the client" +
                                "It also has a history of stealing from mod creators and is overall not really fun to support." +
                                "Please use either native Fabric, or use Quilt (If the mod provides support for it)."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}