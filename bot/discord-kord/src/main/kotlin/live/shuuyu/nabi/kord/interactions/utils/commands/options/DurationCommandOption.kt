package live.shuuyu.nabi.kord.interactions.utils.commands.options

import dev.kord.common.Locale
import dev.kord.common.entity.CommandArgument
import dev.kord.common.entity.DiscordInteraction
import dev.kord.core.Kord
import dev.kord.rest.builder.interaction.BaseInputChatBuilder
import dev.kord.rest.builder.interaction.string
import net.perfectdreams.discordinteraktions.common.commands.options.DiscordCommandOptionBuilder
import net.perfectdreams.discordinteraktions.common.commands.options.NameableCommandOption
import kotlin.time.Duration

// I will come back to this on a later date. For now, it's not as important.
// The main issue is that I cannot communicate with Discord in order to restrict certain things
// Maybe this will be integrated with a future library.
/*
class DurationCommandOption(
    override val name: String,
    override val description: String,
    override val nameLocalizations: Map<Locale, String>?,
    override val descriptionLocalizations: Map<Locale, String>?,
    val minDuration: Duration,
    val maxDuration: Duration,
    val required: Boolean
): NameableCommandOption<List<Duration>> {
    override fun register(builder: BaseInputChatBuilder) {
        builder.string(name, description) {
            this.nameLocalizations = this@DurationCommandOption.nameLocalizations?.toMutableMap()
            this.descriptionLocalizations = this@DurationCommandOption.nameLocalizations?.toMutableMap()
            this.minLength = this@DurationCommandOption.minDuration.toInt()
            this.required = this@DurationCommandOption.required
        }
    }

    override fun parse(
        kord: Kord,
        args: List<CommandArgument<*>>,
        interaction: DiscordInteraction
    ): List<Duration>? {
        val value = args.first { it.name == name }.value as String

        return List<Duration>()
    }
}

class DurationCommandOptionBuilder(
    override val name: String,
    override val required: Boolean,
    override val description: String,
): DiscordCommandOptionBuilder<List<Duration>, List<Duration>>() {


    override fun build() = DurationCommandOption(
        name,
        description,
        nameLocalizations,
        descriptionLocalizations,

    )
}
 */
