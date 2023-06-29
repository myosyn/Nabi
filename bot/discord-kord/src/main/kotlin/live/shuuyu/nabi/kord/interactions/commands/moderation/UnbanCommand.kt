package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.cache.data.GuildData
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
        val target = args[options.user]
        val unbanReason = args[options.reason] ?: "No reason provided"

        // This cannot be nullable as you require a guild to unban someone
        val guildId = (context as? GuildApplicationCommandContext)!!.guildId
        val guild = Guild(GuildData.from(rest.guild.getGuild(guildId)), kord)

        unbanUser((context as? GuildApplicationCommandContext)!!,target, guild, unbanReason)
    }

    private suspend fun unbanUser(
        context: GuildApplicationCommandContext,
        user: User,
        guild: Guild,
        reason: String?
    ) {
        guild.unban(user.id, reason)

        context.sendEphemeralMessage {
            content = "$user has been unbanned."
        }
    }
}

class UnbanDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("unban", "Unbans the requested user from the guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.BanMembers
        }

        executor = UnbanExecutor(nabi)
    }

}