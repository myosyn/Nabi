package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.core.behavior.ban
import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandExecutor
import live.shuuyu.discordinteraktions.common.commands.options.ApplicationCommandOptions
import live.shuuyu.discordinteraktions.common.commands.options.SlashCommandArguments
import live.shuuyu.nabi.kord.NabiKordCore

class BanExecutor(val nabi: NabiKordCore) : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]

        val rest = nabi.rest
        // val guild = Guild(GuildData.from(rest.guild.getGuild()), nabi.kord)
        val user = User(UserData.from(rest.user.getUser(target.id)), nabi.kord)
    }

    private suspend fun banUser(data: BanData) {
        val guild = Guild(data.guild, nabi.kord)
        val user = User(data.user, nabi.kord)
        val reason = data.reason

        guild.ban(user.id) {
            this.reason = reason
        }
    }

    class BanData(
        val guild: GuildData,
        val reason: String,
        val user: UserData
    )
}