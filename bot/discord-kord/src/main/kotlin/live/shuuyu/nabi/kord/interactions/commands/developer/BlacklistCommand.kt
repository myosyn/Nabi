package live.shuuyu.nabi.kord.interactions.commands.developer

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class BlacklistCommand(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val user = optionalUser("user", "This option will forbid a user from using Nabi.")
    }

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {

    }
}