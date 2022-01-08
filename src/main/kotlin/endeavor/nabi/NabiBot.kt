@file:OptIn(PrivilegedIntent::class)

package endeavor.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.checks.isNotBot
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.modules.extra.phishing.DetectionAction
import com.kotlindiscord.kord.extensions.modules.extra.phishing.extPhishing
import com.kotlindiscord.kord.extensions.utils.envOrNull
import endeavor.nabi.utils.GUILD_ID
import org.koin.core.logger.Level
import template.extensions.TestExtension

val MODE =  envOrNull("MODE")?.lowercase() ?: "nabi"

suspend fun main() {
    val bot = ExtensibleBot(BOT_TOKEN) {
        koinLogLevel = Level.DEBUG

        applicationCommands {
            enabled = true
        }

        members {
            fill(GUILD_ID)
        }

        extensions {
            add {::Ping}
            add {::Ban}
            add {::PurgeMessages}

            extPhishing {
                appName = "Nabi"
                detectionAction = DetectionAction.Ban
                requiredCommandPermission = null
            }
        }


        }
    }
    bot.start()
}