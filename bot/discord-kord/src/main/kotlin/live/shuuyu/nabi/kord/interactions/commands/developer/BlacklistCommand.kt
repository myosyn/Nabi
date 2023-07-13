package live.shuuyu.nabi.kord.interactions.commands.developer

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.database.tables.BlacklistedUser
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class BlacklistCommand(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val user = user("user", "This option will forbid a user from using Nabi.")
        val reason = optionalString("reason", "This is the reason why this user is being blacklisted.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val blacklistReason = args[options.reason]

        val referToBlacklist = transaction {
            BlacklistedUser.insert {

            }
        }
    }

    private fun validateBlacklist(

    ) {
        when {

        }
    }
}