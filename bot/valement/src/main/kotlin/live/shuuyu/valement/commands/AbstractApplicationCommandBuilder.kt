package live.shuuyu.valement.commands

import live.shuuyu.valement.commands.options.ApplicationCommandOptions
import live.shuuyu.valement.commands.options.SlashCommandArguments

abstract class AbstractSlashCommand {
    open val options: ApplicationCommandOptions = ApplicationCommandOptions.NO_OPTIONS

    abstract suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments)
}