package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class KickExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to kick from the server.")
        val reason = optionalString("reason", "The reason why this user is being kicked.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val user = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."

        val guildId = (context as? GuildApplicationCommandContext)!!.guildId
        val guild = GuildData.from(nabi.rest.guild.getGuild(guildId))


    }

    private suspend fun kick(data: KickData) {
        val reason = data.reason
        val guild = Guild(data.guild, nabi.kord)
        val user = User(data.user, nabi.kord)

        guild.kick(user.id, reason)
    }

    class KickData(
        val reason: String?,
        val guild: GuildData,
        val user: UserData,
    )
}