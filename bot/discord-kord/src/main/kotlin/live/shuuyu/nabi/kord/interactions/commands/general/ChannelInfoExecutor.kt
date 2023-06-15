package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.entity.ChannelType
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.builder.message.actionRow
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class ChannelInfoExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = channel("channel", "The channel you want to look up information on.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.channel]

        val channelType = when (target.type) {
            ChannelType.GuildText -> "Text Channel"
            ChannelType.GuildVoice -> "Voice Channel"
            ChannelType.GuildStageVoice -> "Voice Channel (Stage)"
            ChannelType.PrivateThread -> "Private Thread"
            ChannelType.GuildForum -> "Forum"
            else -> error("This should never return!")
        }

        context.sendMessage {
            embed {
                field {
                    name = "Channel Information"
                    value = "**Channel Type:** $channelType"
                }
            }
            actionRow {
                
            }
        }
    }
}