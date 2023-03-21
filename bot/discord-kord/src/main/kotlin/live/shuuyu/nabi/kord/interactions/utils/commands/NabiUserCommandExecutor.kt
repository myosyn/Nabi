package live.shuuyu.nabi.kord.interactions.utils.commands

import live.shuuyu.discordinteraktions.common.commands.UserCommandExecutor
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging

abstract class NabiUserCommandExecutor(val nabi: NabiKordCore) : UserCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    val rest = nabi.rest
}