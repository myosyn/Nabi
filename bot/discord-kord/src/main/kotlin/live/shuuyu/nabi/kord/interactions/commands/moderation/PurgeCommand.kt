package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.channel.asChannelOfOrNull
import dev.kord.core.cache.data.ChannelData
import dev.kord.core.entity.channel.Channel
import dev.kord.core.entity.channel.GuildMessageChannel
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.json.request.BulkDeleteRequest
import dev.kord.rest.route.Route
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.BarebonesInteractionContext
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class PurgeExecutor(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val messageCount = integer("message_count", "The amount of messages you want to delete.") {
            minValue = 1
        }
        val channel = optionalChannel("channel", "The channel which you want to delete messages from.") {

        }
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val channel = args[options.channel] ?:
            Channel.from(ChannelData.from(rest.channel.getChannel(context.channelId)), kord)


    }

    private suspend fun purgeChannel(channel: Channel) {
        /*
        when(channel) {
            is TextChannel -> channel.bulkDelete()

        }
         */
    }

    private suspend fun validatePurge(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments,
        channel: Channel
    ): Boolean {
        val messageCount = args[options.messageCount]

        when {
            Permission.ManageMessages !in context.appPermissions -> {
                context.sendEphemeralMessage {
                    content = "**I'm currently missing the `MANAGE_MESSAGES` permission!**"
                }
                return false
            }

            else -> return true
        }
    }
}

class PurgeDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("purge", "Erases a select amount of messages.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageMessages
        }

        dmPermission = false

        executor = PurgeExecutor(nabi)
    }
}