import live.shuuyu.valement.commands.AbstractSlashCommand
import live.shuuyu.valement.commands.ApplicationCommandContext
import live.shuuyu.valement.commands.options.SlashCommandArgument

class TestCommand : AbstractSlashCommand() {
    inner class Options : SlashCommandArgument() {
        val user = user("yeah", "wtf")
    }

    override suspend fun execute(ctx: ApplicationCommandContext, args: SlashCommandArgument) {

    }

}