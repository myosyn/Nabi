package live.shuuyu.nabi.gateway

import dev.kord.common.entity.Snowflake
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.utils.env

object GatewayLauncher {
    private val token = env("TOKEN")
    private val applicationId = Snowflake(env("APPLICATION_ID"))

    suspend fun launchKordInstance() {
        val core = NabiKordCore(token, applicationId)
        core.start(1, 1)
    }
}

suspend fun main(args: Array<String>) {
    GatewayLauncher.launchKordInstance()
}