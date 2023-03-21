package live.shuuyu.nabi

import dev.kord.common.annotation.*
import dev.kord.common.entity.PresenceStatus
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.gateway.*
import dev.kord.rest.ratelimit.ParallelRequestRateLimiter
import dev.kord.rest.request.*
import dev.kord.rest.service.RestClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import live.shuuyu.discordinteraktions.common.DiscordInteraKTions
import live.shuuyu.discordinteraktions.platforms.kord.installDiscordInteraKTions
import live.shuuyu.nabi.interactions.RegisterInteractions
import mu.KotlinLogging

class NabiCore(
    val token: String,
    val applicationId: Snowflake
) {
    companion object {
        val logger = KotlinLogging.logger("Nabi")
    }

    @OptIn(KordUnsafe::class)
    val rest = RestClient(
        KtorRequestHandler(
            token,
            ParallelRequestRateLimiter()
        )
    )

    @OptIn(KordExperimental::class)
    val kord = Kord.restOnly(token) {
        requestHandler {
            StackTraceRecoveringKtorRequestHandler(KtorRequestHandler(it.token))
        }
    }

    val interactions = DiscordInteraKTions(token, applicationId)
    val registerGlobalInteractions = RegisterInteractions(this, interactions)

    @OptIn(PrivilegedIntent::class)
    suspend fun start() {
        val gateway = DefaultGateway {
            dispatcher = Dispatchers.Default
        }

        runBlocking {
            launch {
                gateway.start(token) {
                    intents = Intents {
                        +Intent.DirectMessages
                        +Intent.GuildMembers
                        +Intent.GuildMessages
                        +Intent.GuildWebhooks
                    }

                    presence {
                        status = PresenceStatus.Online
                    }

                    gateway.installDiscordInteraKTions(interactions)
                    registerGlobalInteractions.registerCommands()
                }
            }
        }
    }
}