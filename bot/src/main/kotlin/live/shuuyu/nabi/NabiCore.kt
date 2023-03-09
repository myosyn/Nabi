package live.shuuyu.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import com.kotlindiscord.kord.extensions.utils.envOrNull
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.gateway.builder.Shards
import live.shuuyu.nabi.commands.general.RoleCommand
import live.shuuyu.nabi.commands.moderation.BanCommand
import mu.KotlinLogging
import org.jetbrains.exposed.sql.Database

@OptIn(PrivilegedIntent::class)
object NabiCore {
    val logger = KotlinLogging.logger("Nabi:")
    val token = env("TOKEN")

    suspend fun initialize() {
        val shardInstances = envOrNull("SHARD_COUNT")?.toInt() ?: 1

        val bot = ExtensibleBot(token) {

            applicationCommands {
                enabled = true
            }

            extensions {
                add(::RoleCommand)
                add(::BanCommand)
            }

            intents {
                +Intent.DirectMessages
                +Intent.GuildMembers
            }

            kord {
                sharding {
                    Shards(shardInstances)
                }
            }

            i18n {
                interactionUserLocaleResolver()
            }
        }

        bot.start()
    }

    suspend fun initDatabase() {
        val database = Database.connect("jdbc:postgresql://")
    }

    suspend fun restonly(kord: Kord, token: String) {

    }
}

suspend fun main() {
    NabiCore.initialize()


}