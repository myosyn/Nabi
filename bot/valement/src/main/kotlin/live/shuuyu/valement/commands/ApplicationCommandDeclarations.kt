package live.shuuyu.valement.commands

import dev.kord.common.Locale

sealed class ApplicationCommandDeclaration {
    abstract val name: String
    abstract val nameLocalizations: Map<Locale, String>
}