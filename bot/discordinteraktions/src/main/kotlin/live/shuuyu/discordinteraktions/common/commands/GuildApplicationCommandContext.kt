package live.shuuyu.discordinteraktions.common.commands

import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import live.shuuyu.discordinteraktions.common.interactions.InteractionData
import live.shuuyu.discordinteraktions.common.requests.RequestBridge

open class GuildApplicationCommandContext(
    bridge: RequestBridge,
    sender: User,
    channelId: Snowflake,
    data: InteractionData,
    discordInteractionData: DiscordInteraction,
    applicationCommandDeclaration: ApplicationCommandDeclaration,
    val guildId: Snowflake,
    val member: Member
) : ApplicationCommandContext(bridge, sender, channelId, data, discordInteractionData, applicationCommandDeclaration) {
    val appPermissions = discordInteractionData.appPermissions.value
        ?: error("App Permissions field is null on a Guild Interaction! Bug?")
}