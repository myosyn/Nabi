package live.shuuyu.nabi.kord.interactions.utils.commands

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

@OptIn(DelicateCoroutinesApi::class)
abstract class NabiSlashCommandExecutor(val nabi: NabiKordCore) : SlashCommandExecutor(), CommandExecutorUtils {
    companion object {
        private val logger = KotlinLogging.logger {  }
    }


    val rest = nabi.rest
    val kord = nabi.kord

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        GlobalScope.launch {

        }
    }
}