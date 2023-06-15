package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.behavior.ban
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
import kotlin.time.Duration

class BanExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why this user is being banned.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val banReason = args[options.reason] ?: "No reason provided"

        val rest = nabi.rest
        val guildId = (context as? GuildApplicationCommandContext)!!.guildId
        val guild = Guild(GuildData.from(rest.guild.getGuild(guildId)), nabi.kord)
        val user = User(UserData.from(rest.user.getUser(target.id)), nabi.kord)


    }


    private suspend fun banUser(data: BanData) {
        val guild = Guild(data.guild, nabi.kord)
        val user = User(data.user, nabi.kord)
        val reason = data.reason
        val deleteMessageDuration = data.deleteMessageDuration

        guild.ban(user.id) {
            this.reason = reason
            this.deleteMessageDuration = deleteMessageDuration
        }
    }

    private class BanData(
        val guild: GuildData,
        val reason: String,
        val user: UserData,
        val deleteMessageDuration: Duration
    )
}