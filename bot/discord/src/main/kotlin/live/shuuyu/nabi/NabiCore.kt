package live.shuuyu.nabi

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordUnsafe
import dev.kord.core.Kord
import dev.kord.rest.ratelimit.ParallelRequestRateLimiter
import dev.kord.rest.request.KtorRequestHandler
import dev.kord.rest.request.StackTraceRecoveringKtorRequestHandler
import dev.kord.rest.service.RestClient
import mu.KotlinLogging

class NabiCore(
    token: String
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


}