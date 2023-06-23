package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.ChannelType
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.entity.Guild
import dev.kord.core.entity.channel.Channel
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class SlowmodeExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel you want to slow down.") {

        }

    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val targetChannel = args[options.channel]
    }

    private suspend fun slowmode(guild: Guild, channel: Channel) {
        val type = when (channel.type) {
            is ChannelType.GuildText -> {

            }
            else -> error("This should never return!")
        }
    }
}

class SlowmodeDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows down the requested channel.") {
        defaultMemberPermissions = Permissions {
            +Permission.ManageChannels
        }
        executor = SlowmodeExecutor(nabi)
    }
}