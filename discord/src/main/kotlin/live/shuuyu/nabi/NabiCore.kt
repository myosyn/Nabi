package live.shuuyu.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.i18n.SupportedLocales
import dev.kord.common.Locale
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import live.shuuyu.nabi.Constants.TOKEN
import live.shuuyu.nabi.commands.*

object NabiCore {
    @OptIn(PrivilegedIntent::class)
    suspend fun initialize() {
        val bot = ExtensibleBot(TOKEN) {
            applicationCommands {
                enabled = true
            }

            i18n {
                defaultLocale = SupportedLocales.ENGLISH
                interactionUserLocaleResolver()
                applicationCommandLocale(Locale.ENGLISH_UNITED_STATES)
            }

            intents {
                +Intent.GuildMembers
            }

            extensions {
                add(::UserCommand)
                add(::ChannelCommand)
            }
        }

        bot.start()
    }
}

suspend fun main() {
    NabiCore.initialize()
}