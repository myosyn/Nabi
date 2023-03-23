package live.shuuyu.nabi.jda

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.MemberCachePolicy

class NabiJdaCore(
    val token: String,
    val jda: JDA
) {
    fun start() {
        val jda = JDABuilder.createLight(
            token,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_MODERATION,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGES
        )
            .setMemberCachePolicy(MemberCachePolicy.DEFAULT)
            .build()
    }
}