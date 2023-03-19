package live.shuuyu.discordinteraktions.common.commands

import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.InteractionContext
import live.shuuyu.discordinteraktions.common.interactions.InteractionData
import live.shuuyu.discordinteraktions.common.requests.RequestBridge

open class ApplicationCommandContext(
    bridge: RequestBridge,
    sender: User,
    channelId: Snowflake,
    data: InteractionData,
    discordInteractionData: DiscordInteraction,
    val applicationCommandDeclaration: ApplicationCommandDeclaration
) : InteractionContext(bridge, sender, channelId, data, discordInteractionData)