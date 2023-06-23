package live.shuuyu.nabi.kord.interactions

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.declarators.*
import live.shuuyu.nabi.kord.interactions.commands.moderation.*
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.DiscordInteraKTions

class RegisterInteractions(
    private val nabi: NabiKordCore,
    val interaktions: DiscordInteraKTions
) {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    suspend fun registerCommands() {
        interaktions.manager.register(UserDeclarator(nabi))

        logger.info { "Registering all moderation related commands..." }
        // Moderation specific commands
        interaktions.manager.register(KickDeclarator(nabi))
        interaktions.manager.register(NabiInfoDeclarator(nabi))
        interaktions.manager.register(RoleInfoDeclarator)
        interaktions.manager.register(SlowmodeDeclarator(nabi))
        interaktions.manager.register(TimeoutDeclarator(nabi))
        interaktions.updateAllGlobalCommands()
    }

    suspend fun registerGuildRelatedCommands() {

    }
}