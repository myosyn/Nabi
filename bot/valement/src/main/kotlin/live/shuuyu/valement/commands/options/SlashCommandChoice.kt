package live.shuuyu.valement.commands.options

import dev.kord.common.Locale

class SlashCommandChoice<T>(
    val name: String,
    val value: T,
    val nameLocalization: Map<Locale, String>?
)