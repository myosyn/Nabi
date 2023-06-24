package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class GuildInfoExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val guild = Guild(GuildData.from(nabi.rest.guild.getGuild(context.guildId)), nabi.kord)
    }
}