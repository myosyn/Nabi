package live.shuuyu.valement.commands

import live.shuuyu.valement.commands.options.SlashCommandArgument

abstract class AbstractSlashCommand {
    abstract suspend fun execute(ctx: ApplicationCommandContext, args: SlashCommandArgument)
}