import live.shuuyu.valement.commands.AbstractSlashCommand
import live.shuuyu.valement.commands.ApplicationCommandContext
import live.shuuyu.valement.commands.options.ApplicationCommandOptions
import live.shuuyu.valement.commands.options.SlashCommandArguments

class TestCommand : AbstractSlashCommand() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("yeah", "wtf")
    }

    override val options = Options()

    override suspend fun execute(ctx: ApplicationCommandContext, args: SlashCommandArguments) {

    }

}