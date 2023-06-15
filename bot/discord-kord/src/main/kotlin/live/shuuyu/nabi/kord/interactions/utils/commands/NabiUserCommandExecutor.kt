package live.shuuyu.nabi.kord.interactions.utils.commands

import dev.kord.core.entity.Message
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.UserCommandExecutor

abstract class NabiUserCommandExecutor(val nabi: NabiKordCore) : UserCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    val rest = nabi.rest

    abstract suspend fun execute(ctx: GuildApplicationCommandContext, user: User, message: Message)
}