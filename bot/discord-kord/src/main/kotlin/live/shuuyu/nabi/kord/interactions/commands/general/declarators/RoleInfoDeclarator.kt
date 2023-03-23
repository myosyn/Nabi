package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.kord.interactions.commands.general.RoleInfoExecutor

object RoleInfoDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("role", "Gives information about the provided role.") {
        executor = RoleInfoExecutor()
    }
}