package live.shuuyu.nabi.kord.interactions.commands.general.declarators

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.interactions.commands.general.UserInfoSlashExecutor
import live.shuuyu.nabi.kord.interactions.commands.general.UserInfoUserExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class UserInfoSlashDeclarator(val nabi: NabiKordCore) : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("user", "Looks up information on a user.") {
        executor = UserInfoSlashExecutor(nabi)
    }
}

class UserInfoUserDeclarator(val nabi: NabiKordCore) : UserCommandDeclarationWrapper {
    override fun declaration() = userCommand("Look up user information", UserInfoUserExecutor(nabi))
}