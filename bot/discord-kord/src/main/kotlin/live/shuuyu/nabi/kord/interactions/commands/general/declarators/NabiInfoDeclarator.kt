package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import live.shuuyu.discordinteraktions.common.commands.slashCommand
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.NabiInfoExecutor

class NabiInfoDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("info", "Displays all statistics of Nabi.") {
        executor = NabiInfoExecutor(nabi)
    }
}