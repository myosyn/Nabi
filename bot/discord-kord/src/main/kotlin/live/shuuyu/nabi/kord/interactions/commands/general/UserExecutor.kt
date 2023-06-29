package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.core.cache.data.MemberData
import dev.kord.core.entity.Member
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments


class UserExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to look up.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender


        context.sendMessage {
            embed {
                title = target.username
                field {
                    name = "**» User Information**"
                    value = "**Mention:** ${target.mention} \n" +
                            "**ID:** ${target.id}"
                }
                field {
                    name = "**» Member Information**"
                }
                timestamp = Clock.System.now()
            }
        }
    }

    private fun userFlags() {

    }
}