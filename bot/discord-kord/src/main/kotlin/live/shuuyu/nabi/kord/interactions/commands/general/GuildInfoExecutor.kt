package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class GuildInfoExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val guild = Guild(GuildData.from(rest.guild.getGuild(context.guildId)), kord)

        context.sendMessage {
            embed {
                title = guild.name
                description = "**Creation Date:** ${guild.id.timestamp.toMessageFormat(DiscordTimestampStyle.LongDate)} \n" +
                        "**Owner:** ${guild.owner}"
                 
            }
        }
    }
}

