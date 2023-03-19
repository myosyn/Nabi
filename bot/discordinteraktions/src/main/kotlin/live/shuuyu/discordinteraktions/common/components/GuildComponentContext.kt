package live.shuuyu.discordinteraktions.common.components

import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.entities.messages.Message
import live.shuuyu.discordinteraktions.common.interactions.InteractionData
import live.shuuyu.discordinteraktions.common.requests.RequestBridge

open class GuildComponentContext(
    bridge: RequestBridge,
    sender: User,
    channelId: Snowflake,
    declaration: ComponentExecutorDeclaration,
    message: Message,
    dataOrNull: String?,
    interactionData: InteractionData,
    discordInteractionData: DiscordInteraction,
    val guildId: Snowflake,
    val member: Member
) : ComponentContext(
    bridge,
    sender,
    channelId,
    declaration,
    message,
    dataOrNull,
    interactionData,
    discordInteractionData
) {
    val appPermissions = discordInteractionData.appPermissions.value
        ?: error("App Permissions field is null on a Guild Interaction! Bug?")
}