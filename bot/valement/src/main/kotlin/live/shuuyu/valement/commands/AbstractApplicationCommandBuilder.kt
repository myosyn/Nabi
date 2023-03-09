package live.shuuyu.valement.commands

import live.shuuyu.valement.annotations.PleaseSendHelp
import live.shuuyu.valement.commands.options.SlashCommandArgument

@PleaseSendHelp
abstract class AbstractSlashCommand {
    abstract suspend fun execute(ctx: ApplicationCommandContext, args: SlashCommandArgument)
}