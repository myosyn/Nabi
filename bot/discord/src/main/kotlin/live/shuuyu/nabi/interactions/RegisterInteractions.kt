package live.shuuyu.nabi.interactions

import dev.kord.common.entity.Snowflake
import live.shuuyu.discordinteraktions.common.DiscordInteraKTions
import live.shuuyu.nabi.interactions.commands.general.declarators.UserDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.KickDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.SlowmodeDeclarator
import live.shuuyu.nabi.interactions.commands.moderation.declarators.TimeoutDeclarator

class RegisterInteractions(
    val token: String
) {
    companion object {
        val APPID = Snowflake("927084188237180979")
        // App ID is already public so I don't mind putting it here
    }

    val interactions = DiscordInteraKTions(token, APPID)

    suspend fun registerCommands() {
        interactions.manager.register(UserDeclarator)

        // Moderation specific commands
        interactions.manager.register(KickDeclarator)
        interactions.manager.register(SlowmodeDeclarator)
        interactions.manager.register(TimeoutDeclarator)
        interactions.updateAllGlobalCommands()
    }
}