package live.shuuyu.nabi.gateway

import dev.kord.common.entity.Snowflake
import io.github.cdimascio.dotenv.dotenv
import live.shuuyu.nabi.kord.NabiKordCore
import mu.KotlinLogging

object GatewayLauncher {
    private val env = dotenv()
    private val token: String = env["TOKEN"]
    private val applicationId = Snowflake(env["APPLICATIONID"])
    private val logger = KotlinLogging.logger { }

    suspend fun launch() {
        logger.info("Launching the Kord instance!")
        val nabi = NabiKordCore(token, applicationId)

        nabi.start()
    }

    suspend fun initDatabase() {

    }
}

suspend fun main() {
    GatewayLauncher.launch()
}