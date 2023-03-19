package live.shuuyu.discordinteraktions.common.modals

import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.InteractionContext
import live.shuuyu.discordinteraktions.common.interactions.InteractionData
import live.shuuyu.discordinteraktions.common.requests.RequestBridge

open class ModalContext(
    bridge: RequestBridge,
    sender: User,
    channelId: Snowflake,
    val modalExecutorDeclaration: ModalExecutorDeclaration,
    val dataOrNull: String?,
    data: InteractionData,
    discordInteractionData: DiscordInteraction
) : InteractionContext(bridge, sender, channelId, data, discordInteractionData) {
    val data: String
        get() = dataOrNull ?: error("There isn't any custom data present in this modal submit context!")
}