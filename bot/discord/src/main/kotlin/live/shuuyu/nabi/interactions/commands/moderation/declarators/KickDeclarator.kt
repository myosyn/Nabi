package live.shuuyu.nabi.interactions.commands.moderation.declarators

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.interactions.commands.moderation.KickExecutor

object KickDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks a user from the current guild.") {
        defaultMemberPermissions = Permissions {
            +Permission.KickMembers
        }
        executor = KickExecutor()
    }
}