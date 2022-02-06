@file:OptIn(PrivilegedIntent::class)

package myosyn.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.modules.extra.phishing.DetectionAction
import com.kotlindiscord.kord.extensions.modules.extra.phishing.extPhishing
import com.kotlindiscord.kord.extensions.utils.envOrNull
import dev.kord.gateway.PrivilegedIntent
import myosyn.nabi.utils.DISCORD_TOKEN

/*
Imports the commands that we require.
Because I decided I'd have them in separate files
like an idiot.
 */
import myosyn.nabi.extensions.commands.moderation.*
import myosyn.nabi.extensions.commands.developer.*
import myosyn.nabi.extensions.commands.general.*
import myosyn.nabi.extensions.commands.logging.ModLogs

import org.koin.core.logger.Level

val MODE =  envOrNull("MODE")?.lowercase() ?: "nabi"


@OptIn(PrivilegedIntent::class)
@Suppress("BlockingMethodInNonBlockingContext")
suspend fun main() {
    val bot = ExtensibleBot(DISCORD_TOKEN) {
        koinLogLevel = Level.DEBUG

        applicationCommands {
            enabled = true
        }

        extensions {
            add ( ::BotBan )
            add ( ::BotSay )
            add ( ::RestartBot )
            add ( ::Shutdown )
            add ( ::Info )
            add ( ::Ping )
            add ( ::User )
            add ( ::ModLogs )
            add ( ::Ban )
            add ( ::GiveRole )
            add ( ::Kick )
            add ( ::PurgeMessages )
            add ( ::TakeRole )
            add ( ::TempBan )
            add ( ::Timeout )
            add ( ::Unban )
            add ( ::Untimeout )
            add ( ::Warn )
        }
    }
    bot.start()
}