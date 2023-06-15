package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.NabiInfoExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

class NabiInfoDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("info", "Displays all statistics of Nabi.") {
        executor = NabiInfoExecutor(nabi)
    }
}