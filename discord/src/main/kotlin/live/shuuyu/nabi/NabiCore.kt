package live.shuuyu.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import live.shuuyu.nabi.Constants.TOKEN

object NabiCore {
    suspend fun initialize() {
        val bot = ExtensibleBot(TOKEN) {
            applicationCommands {
                enabled = true
            }
        }

        bot.start()
    }
}

suspend fun main() {
    NabiCore.initialize()
}