package live.shuuyu.nabi.kord.utils.locales

import dev.kord.common.Locale
import java.text.MessageFormat

interface TranslationProvider {
    val supportedLocales: Set<Locale>

    val defaultModule: String

    val defaultLocale: Locale

    fun supportsLocale(locale: Locale, module: String = defaultModule): Boolean

    fun translate(
        key: String,
        vararg replaceWith: Any,
        locale: Locale = defaultLocale,
        module: String = defaultModule
    ): String

    fun getAllStrings(key: String, module: String = defaultModule): Map<Locale, String>

    fun format(value: String, vararg params: Any): String = MessageFormat.format(value, *params)
}