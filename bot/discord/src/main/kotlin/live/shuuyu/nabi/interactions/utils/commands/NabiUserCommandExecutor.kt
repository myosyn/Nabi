package live.shuuyu.nabi.interactions.utils.commands

import live.shuuyu.discordinteraktions.common.commands.UserCommandExecutor
import live.shuuyu.nabi.NabiCore
import mu.KotlinLogging

abstract class NabiUserCommandExecutor(val nabi: NabiCore) : UserCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    val rest = nabi.rest
}