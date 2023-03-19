package live.shuuyu.discordinteraktions.platforms.kord

import dev.kord.common.entity.InteractionType
import dev.kord.gateway.Gateway
import dev.kord.gateway.InteractionCreate
import dev.kord.gateway.on
import live.shuuyu.discordinteraktions.common.DiscordInteraKTions
import live.shuuyu.discordinteraktions.common.requests.InteractionRequestState
import live.shuuyu.discordinteraktions.common.requests.RequestBridge
import live.shuuyu.discordinteraktions.common.requests.managers.InitialHttpRequestManager
import live.shuuyu.discordinteraktions.common.utils.Observable

fun Gateway.installDiscordInteraKTions(interaKTions: DiscordInteraKTions) {
    on<InteractionCreate> {
        val request = this.interaction

        val observableState = Observable(InteractionRequestState.NOT_REPLIED_YET)
        val bridge = RequestBridge(observableState)

        val requestManager = InitialHttpRequestManager(
            bridge,
            interaKTions.kord,
            interaKTions.applicationId,
            request.id,
            request.token
        )

        bridge.manager = requestManager

        when (request.type) {
            InteractionType.ApplicationCommand -> interaKTions.commandChecker.checkAndExecute(
                request,
                requestManager
            )

            InteractionType.Component -> interaKTions.componentChecker.checkAndExecute(
                request,
                requestManager
            )

            InteractionType.AutoComplete -> interaKTions.autocompleteChecker.checkAndExecute(
                request,
                requestManager
            )

            InteractionType.ModalSubmit -> interaKTions.modalChecker.checkAndExecute(
                request,
                requestManager
            )

            else -> {}
        }
    }
}