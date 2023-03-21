package live.shuuyu.nabi.interactions.commands.general

import live.shuuyu.discordinteraktions.common.builder.message.embed
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import net.perfectdreams.discordinteraktions.common.utils.field

class UserExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to look up.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender

        context.sendMessage {
            embed {
                title = target.username

                field(
                    "» User Information",
                    "**User ID:** ${target.id} \n" +
                            "**Mention:** ${target.mention} \n",
                    false
                )

            }
        }
    }

    private fun userFlags() {

    }
}