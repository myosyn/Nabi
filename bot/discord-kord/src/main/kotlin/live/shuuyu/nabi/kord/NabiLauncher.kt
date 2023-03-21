package live.shuuyu.nabi.kord

import dev.kord.common.entity.Snowflake
import dev.kord.gateway.DefaultGateway
import io.github.cdimascio.dotenv.dotenv
import mu.KotlinLogging

object NabiLauncher {
    private val logger = KotlinLogging.logger("Nabi")

    suspend fun initialize() {
        val gateway = DefaultGateway()
    }
}

suspend fun main(args: Array<String>) {
    val env = dotenv()
    val nabi = NabiKordCore(
        env["TOKEN"],
        Snowflake(env["APP_ID"])
    )

    nabi.start()
}