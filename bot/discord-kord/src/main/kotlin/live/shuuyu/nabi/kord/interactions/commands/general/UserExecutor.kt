package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.cache.data.MemberData
import dev.kord.core.entity.Member
import dev.kord.rest.builder.message.EmbedBuilder
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments


class UserExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to look up.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender
        val targetAsMember = (context as GuildApplicationCommandContext).member



        context.sendMessage {
            embed {
                title = target.username
                image = target.banner?.cdnUrl?.toUrl()

                field {
                    name = "**» User Information**"
                    value = "**Mention:** ${target.mention} \n" +
                            "**Account Creation:** ${target.id.timestamp.toMessageFormat(DiscordTimestampStyle.LongDate)} \n" +
                            "**ID:** ${target.id}"
                }
                field {
                    name = "**» Member Information**"
                    value = "**Join Date:** ${targetAsMember.joinedAt.toMessageFormat(DiscordTimestampStyle.LongDate)}"
                }
                timestamp = Clock.System.now()
            }
        }
    }
}