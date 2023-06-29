package live.shuuyu.nabi.kord.interactions.utils.commands

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.MessageCommandExecutor
import net.perfectdreams.discordinteraktions.common.entities.messages.Message

@OptIn(DelicateCoroutinesApi::class)
abstract class NabiMessageCommandExecutor(val nabi: NabiKordCore): MessageCommandExecutor(), CommandExecutorUtils {
    companion object {
        private val logger = KotlinLogging.logger {  }
    }

    val rest = nabi.rest
    val kord = nabi.kord

    override suspend fun execute(context: ApplicationCommandContext, targetMessage: Message) {
        GlobalScope.launch {

        }
    }
}