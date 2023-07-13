package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.RoleInfoExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

class RoleInfoDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("role", "Gives information about the provided role.") {
        executor = RoleInfoExecutor(nabi)
    }
}