package live.shuuyu.nabi.kord.interactions.commands.moderation

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import dev.kord.core.behavior.edit
import dev.kord.core.cache.data.MemberData
import dev.kord.core.cache.data.UserData
import dev.kord.core.entity.Member
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.NabiSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class UnmuteExecutor(nabi: NabiKordCore): NabiSlashCommandExecutor(nabi) {
    inner class Options: ApplicationCommandOptions() {
        val user = user("user", "The user you want to unmute.")
        val reason = optionalString("reason", "The reason why this user is being unmuted.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        if(context !is GuildApplicationCommandContext)
            return

        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason was provided."
        val memberData = MemberData.from(target.id, context.guildId, rest.guild.getGuildMember(context.guildId, target.id))

        unmuteUser(UnmuteData(target.data, memberData, reason))
    }

    private suspend fun unmuteUser(data: UnmuteData) {
        val member = Member(data.member, data.user, kord)

        member.edit {
            communicationDisabledUntil = Clock.System.now()
            reason = data.reason
        }
    }

    class UnmuteData(
        val user: UserData,
        val member: MemberData,
        val reason: String,
    )
}

class UnmuteDeclarator(val nabi: NabiKordCore): SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("unmute", "Unmutes the specified user in the requested guild.") {
        defaultMemberPermissions = Permissions {
            + Permission.ModerateMembers
        }

        dmPermission = false

        executor = UnmuteExecutor(nabi)
    }
}