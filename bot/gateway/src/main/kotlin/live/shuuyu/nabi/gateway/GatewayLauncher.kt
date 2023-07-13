package live.shuuyu.nabi.gateway

import kotlinx.coroutines.runBlocking
import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.config.config
import live.shuuyu.nabi.kord.database.DatabaseManager

object GatewayLauncher {
    suspend fun launchKordInstance() {
        val database = DatabaseManager()
        val core = NabiKordCore(config.token, config.applicationId)

        runBlocking {
            database.initDatabaseConnection(config.databaseJDBC, config.databaseUsername, config.databasePassword)
            database.createMissingSchemas()

            core.start(config.shardIndex, config.shardCount)
        }
    }
}

suspend fun main(args: Array<String>) {
    GatewayLauncher.launchKordInstance()
}