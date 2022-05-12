package dev.myosyn.nabi.myosyn

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.common.entity.ComponentType
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.ColorUtils.DEFAULT_COLOR
import kotlinx.datetime.Clock

class GetOffOfFeatherClient : Extension() {
    override val name: String = "GetOffOfFeatherClient"

    override suspend fun setup() {
        publicSlashCommand {
            name = "GetOffOfFeatherClient"
            description = "Stop using a client that has a worse reputation than Hunt Down the Refund."

            check {
                anyGuild()
            }

            action {
                respond {
                    embed {
                        color = DEFAULT_COLOR
                        title = "Feather Client Error"
                        description = "You're currently using Feather Client, which is unsupported by us." +
                            "It will break many features in this mod, which is why we went out of our way to deliberately crash the client." +
                                "Please use either native Fabric, or use Quilt (If the mod provides support for it)."
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}