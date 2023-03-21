package live.shuuyu.nabi.interactions

import live.shuuyu.discordinteraktions.common.DiscordInteraKTions
import live.shuuyu.nabi.NabiCore
import live.shuuyu.nabi.interactions.commands.general.declarators.UserDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.KickDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.SlowmodeDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.TimeoutDeclarator
import mu.KotlinLogging

class RegisterInteractions(
    private val nabi: NabiCore,
    val interaktions: DiscordInteraKTions
) {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    suspend fun registerCommands() {
        interaktions.manager.register(UserDeclarator)

        logger.info { "Registering all moderation related commands..." }
        // Moderation specific commands
        interaktions.manager.register(KickDeclarator(nabi))
        interaktions.manager.register(SlowmodeDeclarator)
        interaktions.manager.register(TimeoutDeclarator)
        interaktions.updateAllGlobalCommands()
    }
}