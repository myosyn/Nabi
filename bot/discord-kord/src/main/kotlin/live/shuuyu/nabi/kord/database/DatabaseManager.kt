package live.shuuyu.nabi.kord.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import live.shuuyu.nabi.kord.database.tables.BlacklistedUser
import mu.KotlinLogging
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


class DatabaseManager() {

    companion object {
        val logger = KotlinLogging.logger {  }
    }

    fun initDatabaseConnection(
        databaseUrl: String,
        databaseUsername: String,
        databasePassword: String,
    ) {
        val config = HikariDataSource(HikariConfig().apply {
            jdbcUrl = databaseUrl
            username = databaseUsername
            password = databasePassword
        })

        Database.connect(
            config,
            databaseConfig = DatabaseConfig.invoke {

            }
        )
    }

    fun createMissingSchemas() {
        transaction {
            SchemaUtils.addMissingColumnsStatements(BlacklistedUser)
        }
    }
}