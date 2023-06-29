package live.shuuyu.nabi.kord.interactions

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.ChannelInfoDeclarator
import live.shuuyu.nabi.kord.interactions.commands.general.declarators.*
import live.shuuyu.nabi.kord.interactions.commands.moderation.*
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.DiscordInteraKTions

class RegisterInteractions(
    private val nabi: NabiKordCore,
    val interactions: DiscordInteraKTions
) {
    companion object {
        val logger = KotlinLogging.logger {}
    }

    suspend fun registerCommands() {
        interactions.manager.register(UserDeclarator(nabi))
        interactions.manager.register(ChannelInfoDeclarator(nabi))

        logger.info { "Registering all moderation related commands..." }
        // Moderation specific commands
        interactions.manager.register(KickDeclarator(nabi))
        interactions.manager.register(NabiInfoDeclarator(nabi))
        interactions.manager.register(RoleInfoDeclarator)
        interactions.manager.register(SlowmodeDeclarator(nabi))
        interactions.manager.register(TimeoutDeclarator(nabi))
        interactions.manager.register(UnbanDeclarator(nabi))

        interactions.updateAllGlobalCommands()
    }

    suspend fun registerGuildRelatedCommands() {

    }

    fun register(executor: NabiSlashCommandExecutor) {

    }
}