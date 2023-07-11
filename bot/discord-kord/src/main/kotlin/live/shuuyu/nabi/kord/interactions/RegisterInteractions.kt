package live.shuuyu.nabi.kord.interactions

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.ChannelInfoDeclarator
import live.shuuyu.nabi.kord.interactions.commands.general.declarators.*
import live.shuuyu.nabi.kord.interactions.commands.moderation.*
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.DiscordInteraKTions

class RegisterInteractions(
    private val nabi: NabiKordCore,
    val interactions: DiscordInteraKTions
) {
    companion object {
        val logger = KotlinLogging.logger("Nabi's Interaction Manager")
    }

    suspend fun registerCommands() {
        with(interactions.manager) {
            logger.info("Registering all general related commands.")
            register(UserDeclarator(this@RegisterInteractions.nabi))
            register(ChannelInfoDeclarator(this@RegisterInteractions.nabi))
            register(NabiInfoDeclarator(this@RegisterInteractions.nabi))

            logger.info("Registering all moderation related commands.")
            register(BanDeclarator(this@RegisterInteractions.nabi))
            register(KickDeclarator(this@RegisterInteractions.nabi))
            register(SlowmodeDeclarator(this@RegisterInteractions.nabi))
            register(UnbanDeclarator(this@RegisterInteractions.nabi))
            register(MuteDeclarator(this@RegisterInteractions.nabi))
            register(UnmuteDeclarator(this@RegisterInteractions.nabi))
        }

        logger.info("Uprooting all of the commands")
        interactions.updateAllGlobalCommands()
    }

    suspend fun registerGuildRelatedCommands() {

    }
}