package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.common.serialization.DurationInDays
import dev.kord.core.behavior.ban
import dev.kord.core.cache.data.GuildData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration.Companion.days

class BanExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why this user is being banned.")
        val messageDurationInt = optionalInteger("delete_message_days", "The days worth of messages you want to delete.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if (context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val banReason = args[options.reason] ?: "No reason provided"
        val deleteMessageInteger = args[options.messageDurationInt] ?: 7

        val guildData = GuildData.from(rest.guild.getGuild(context.guildId))

        banUser(BanData(guildData, target.data, banReason, deleteMessageInteger.days))
    }

    private suspend fun banUser(data: BanData) {
        val guild = Guild(data.guild, kord)
        val user = User(data.user, kord)

        guild.ban(user.id) {
            reason = data.reason
            deleteMessageDuration = data.deleteMessageDays
        }
    }

    private class BanData(
        val guild: GuildData,
        val user: UserData,
        val reason: String,
        val deleteMessageDays: DurationInDays
    )
}

class BanDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("ban", "Bans a user from the current guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.BanMembers
        }
        executor = BanExecutor(nabi)
    }
}