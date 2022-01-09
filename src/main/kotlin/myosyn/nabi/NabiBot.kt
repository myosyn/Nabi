@file:OptIn(PrivilegedIntent::class)

package myosyn.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.modules.extra.phishing.DetectionAction
import com.kotlindiscord.kord.extensions.modules.extra.phishing.extPhishing
import com.kotlindiscord.kord.extensions.utils.envOrNull
import dev.kord.gateway.PrivilegedIntent
import myosyn.nabi.utils.BOT_TOKEN

/*
Imports the commands that we require.
Because I decided I'd have them in separate files
like an idiot.
 */
import myosyn.nabi.commands.moderation.*
import myosyn.nabi.commands.developer.*
import myosyn.nabi.commands.general.*

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