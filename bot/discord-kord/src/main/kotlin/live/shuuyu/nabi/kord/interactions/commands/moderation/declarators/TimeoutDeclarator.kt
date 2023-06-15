package live.shuuyu.nabi.kord.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.nabi.kord.interactions.commands.moderation.TimeoutExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

object TimeoutDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("timeout", "Times out the specified user.") {

        defaultMemberPermissions = Permissions {
            +Permission.ModerateMembers
        }

        executor = TimeoutExecutor()
    }
}