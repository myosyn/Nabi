package live.shuuyu.nabi.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.interactions.commands.moderation.TimeoutExecutor

object TimeoutDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("timeout", "Times out the specified user.") {
        defaultMemberPermissions = Permissions {
            +Permission.ModerateMembers
        }

        executor = TimeoutExecutor()
    }

}