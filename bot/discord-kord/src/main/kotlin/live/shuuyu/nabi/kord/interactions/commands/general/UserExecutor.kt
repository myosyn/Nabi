package live.shuuyu.nabi.kord.interactions.commands.general

import kotlinx.datetime.Clock
import live.shuuyu.discordinteraktions.common.builder.message.embed
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments

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
                field {
                    name = "**» User Information**"
                    value = "**Mention:** ${target.mention} \n" +
                            "**ID:** ${target.id}"
                }
                timestamp = Clock.System.now()
            }
        }
    }

    private fun userFlags() {

    }
}