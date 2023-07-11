package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class UnbanExecutor(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val user = user("user", "The user you want to unban.")
        val reason = optionalString("reason", "The reason why this user is being unbanned.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if(context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val unbanReason = args[options.reason] ?: "No reason provided"

        val guild = GuildData.from(rest.guild.getGuild(context.guildId))


        unbanUser(UnbanData(guild, target.data, unbanReason))
    }

    private suspend fun unbanUser(data: UnbanData) {
        val guild = Guild(data.guild, kord)
        val user = User(data.user, kord)

        guild.unban(user.id, data.reason)
    }

    private class UnbanData(
        val guild: GuildData,
        val user: UserData,
        val reason: String
    )
}

class UnbanDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("unban", "Unbans the requested user from the guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.BanMembers
        }

        executor = UnbanExecutor(nabi)
    }

}