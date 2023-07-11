package live.shuuyu.nabi.kord.interactions.utils.commands

import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.UserCommandExecutor

/*
 * There is little to no difference regarding the declaration of both the [UserCommandExecutor] and
 * [NabiUserCommandExecutor], meaning they can be registered under the same registrar.
 *
 * You can only have up to 5 user commands in a single bot.
 */
@OptIn(DelicateCoroutinesApi::class)
abstract class NabiUserCommandExecutor(val nabi: NabiKordCore) : UserCommandExecutor(), CommandExecutorUtils {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    val rest = nabi.rest
    val kord = nabi.kord

    override suspend fun execute(context: ApplicationCommandContext, targetUser: User, targetMember: Member?) {
        GlobalScope.launch {
            // TODO: Add blacklist and owner specific commands
        }
    }
}