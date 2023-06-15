package live.shuuyu.nabi.kord.interactions.utils.commands

import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

abstract class NabiSlashCommandExecutor(nabi: NabiKordCore) : SlashCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {  }
    }

    val rest = nabi.rest

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val guildId = (context as? GuildApplicationCommandContext)?.guildId
    }
}