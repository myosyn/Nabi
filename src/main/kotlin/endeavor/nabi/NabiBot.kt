@file:OptIn(PrivilegedIntent::class)

package endeavor.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import com.kotlindiscord.kord.extensions.checks.isNotBot
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.modules.extra.phishing.DetectionAction
import com.kotlindiscord.kord.extensions.modules.extra.phishing.extPhishing
import com.kotlindiscord.kord.extensions.utils.envOrNull
import dev.kord.gateway.PrivilegedIntent
import endeavor.nabi.utils.BOT_TOKEN

/*
Imports the commands that we require.
Because I decided I'd have them in separate files
like an idiot.
 */
import endeavor.nabi.commands.moderation.*
import endeavor.nabi.commands.developer.*
import endeavor.nabi.commands.general.*

import org.koin.core.logger.Level

val MODE =  envOrNull("MODE")?.lowercase() ?: "nabi"

suspend fun main() {
    val bot = ExtensibleBot(BOT_TOKEN) {
        koinLogLevel = Level.DEBUG

        applicationCommands {
            enabled = true
        }

        extensions {
            add (::Ping)
            add (::Ban)
            add (::PurgeMessages)
            add (::Warn)
            add (::Timeout)
            add (::Kick)
            add (::TempBan)
            add (::BotBan)
            add (::RestartBot)
            add (::SetRPC)
            add (::Shutdown)
            add (::Untimeout)

            extPhishing {
                appName = "Nabi"
                detectionAction = DetectionAction.Ban
                requiredCommandPermission = null
            }
        }
    }
    bot.start()
}