package live.shuuyu.nabi.interactions.commands.general

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
        val target = args[options.user] ?: context.sender.asUser()

        context.sendMessage {
            embed {
                title = target.username

                TODO("Finish this later I forgot to do this last night")
            }
        }
    }
}