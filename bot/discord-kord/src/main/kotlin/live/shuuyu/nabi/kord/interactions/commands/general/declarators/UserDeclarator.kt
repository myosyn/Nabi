package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.kord.interactions.commands.general.UserExecutor

object UserDeclarator : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("user", "Looks up information on a user.") {
        executor = UserExecutor()
    }
}