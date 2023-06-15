package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.UserExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

class UserDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("user", "Looks up information on a user.") {
        executor = UserExecutor(nabi)
    }
}