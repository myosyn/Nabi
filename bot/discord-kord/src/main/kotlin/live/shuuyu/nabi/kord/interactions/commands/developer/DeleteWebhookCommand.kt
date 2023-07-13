package live.shuuyu.nabi.kord.interactions.commands.developer

import dev.kord.common.entity.Snowflake
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

// This is a developer option, so I can delete the RATs that I get.
class DeleteWebhookCommand(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    companion object {
        val DISCORD_WEBHOOK_REGEX = Regex("")
    }

    inner class Options: ApplicationCommandOptions() {
        val url = string("webhook", "The webhook that you want to delete.") {

        }
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {

    }

    private suspend fun deleteWebhook(snowflake: Snowflake) {
        rest.webhook.deleteWebhook(snowflake)
    }
}