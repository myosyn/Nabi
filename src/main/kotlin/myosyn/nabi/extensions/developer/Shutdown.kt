package myosyn.nabi.extensions.developer

import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.ephemeralButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.sentry.BreadcrumbType
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.ButtonStyle
import dev.kord.common.entity.Snowflake
import dev.kord.rest.builder.message.create.embed
import myosyn.nabi.utils.OWNER_ID
import kotlin.system.exitProcess

class Shutdown : Extension() {
    override val name = "shutdown"

    override suspend fun setup() {

        ephemeralSlashCommand {
            name = "shutdown"
            description = "Owner command. Shuts down the entire bot."

            allowUser(Snowflake(OWNER_ID))

            action {
                respond {
                    embed {
                        title = "Shutdown the bot"
                        description = "Are you sure you want to turn off the bot?"
                    }
                    sentry.breadcrumb(BreadcrumbType.Info) {
                        message = "${user.asUser().tag} shut down the bot."
                    }

                    components {
                        ephemeralButton {
                            label = "Confirm Action"
                            style = ButtonStyle.Danger

                            action {
                                respond { content = "Got it! I'll start to turn off." }
                                kord.shutdown()
                                exitProcess(0)
                            }
                        }
                        ephemeralButton {
                            label = "Deny Action"
                            style = ButtonStyle.Success

                            action {
                                respond { content = "You're boring." }
                            }
                        }
                    }
                }
            }
        }
    }
}