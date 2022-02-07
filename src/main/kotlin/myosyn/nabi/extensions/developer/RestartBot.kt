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

class RestartBot : Extension() {
    override val name = "restart"

    override suspend fun setup() {

        ephemeralSlashCommand {
            name = "restart"
            description = "Restarts the entire bot."

            allowUser(Snowflake(OWNER_ID))

            action {
                respond {
                    embed {
                        title = "Restart Nabi"
                        description = "Are you sure you want to restart Nabi?"
                    }
                    sentry.breadcrumb(BreadcrumbType.Info) {
                        message = "${user.asUser().tag} has restarted the bot."
                    }
                    components {
                        ephemeralButton {
                            label = "Confirm Action"
                            style = ButtonStyle.Danger

                            action {
                                respond {
                                    content = "Got it! I'll go and restart."
                                    kord.logout()
                                    kord.shutdown()
                                    exitProcess(0)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}