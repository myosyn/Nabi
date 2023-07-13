package live.shuuyu.nabi.kord.interactions.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import kotlinx.datetime.Clock
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.utils.commands.*
import live.shuuyu.nabi.kord.utils.ColorUtils
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import net.perfectdreams.discordinteraktions.common.utils.field

class UserInfoSlashExecutor(nabi: NabiKordCore) : NabiSlashCommandExecutor(nabi) {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to look up.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender
        val targetAsMember = (context as GuildApplicationCommandContext).member

        context.sendMessage {
            createUserInfoEmbed(target, targetAsMember)
        }
    }
}

// Confusing name? I know.
class UserInfoUserExecutor(nabi: NabiKordCore): NabiUserCommandExecutor(nabi) {
    override suspend fun execute(context: ApplicationCommandContext, targetUser: User, targetMember: Member?) {
        context.sendMessage {
            createUserInfoEmbed(targetUser, targetMember)
        }
    }
}


fun InteractionOrFollowupMessageCreateBuilder.createUserInfoEmbed(
    user: User,
    member: Member?
) {
    embed {
        title = user.username
        field(
            "**» User Information**",
            "**Mention:** ${user.mention} \n" +
                    "**ID:** ${user.id} \n" +
                    "**Account Creation Date:** ${user.id.timestamp.toMessageFormat(DiscordTimestampStyle.LongDate)}"
        )

        if (member != null) {
            field(
                "**» Member Information**",
                "**Join Date:** ${member.joinedAt.toMessageFormat(DiscordTimestampStyle.LongDate)}"
            )
        }

        color = ColorUtils.DEFAULT_COLOR
        timestamp = Clock.System.now()
    }
}
