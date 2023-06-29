package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.behavior.channel.asChannelOfOrNull
import dev.kord.core.entity.channel.Channel
import dev.kord.core.entity.channel.GuildMessageChannel
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.json.request.BulkDeleteRequest
import dev.kord.rest.route.Route
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class PurgeExecutor(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel which you want to delete messages from.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {

    }

    private suspend fun purgeChannel(channel: Channel) {

    }
}