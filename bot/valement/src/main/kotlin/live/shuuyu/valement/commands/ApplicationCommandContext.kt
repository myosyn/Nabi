package live.shuuyu.valement.commands

import dev.kord.common.entity.DiscordInteraction
import dev.kord.common.entity.Snowflake
import dev.kord.core.cache.data.InteractionData
import dev.kord.core.entity.User

open class ApplicationCommandContext(
    sender: User,
    channelId: Snowflake,
    guildId: Snowflake,
    data: InteractionData,
    discordInteraction: DiscordInteraction
)