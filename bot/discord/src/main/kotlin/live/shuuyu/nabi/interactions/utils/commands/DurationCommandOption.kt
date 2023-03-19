package live.shuuyu.nabi.interactions.utils.commands

import dev.kord.common.entity.CommandArgument
import dev.kord.common.entity.DiscordInteraction
import dev.kord.core.Kord
import dev.kord.rest.builder.interaction.BaseInputChatBuilder
import live.shuuyu.discordinteraktions.common.commands.options.InteraKTionsCommandOption
import kotlin.time.Duration

class DurationCommandOption(
    override val name: String
) : InteraKTionsCommandOption<List<Duration>> {
    override fun register(builder: BaseInputChatBuilder) {
        TODO("hi")
    }

    override fun parse(kord: Kord, args: List<CommandArgument<*>>, interaction: DiscordInteraction): List<Duration>? {
        TODO("what")
    }
}