package live.shuuyu.nabi.kord.utils.locales

import dev.kord.common.Locale
import dev.kord.common.asJavaLocale
import mu.KotlinLogging
import java.util.*

class ResourceProvider(
    override val defaultLocale: Locale = Locale.ENGLISH_UNITED_STATES,
    override val supportedLocales: Set<Locale> = Locale.ALL.toSet(),
    override val defaultModule: String = "default"
) : TranslationProvider {
    private val logger = KotlinLogging.logger { }

    private fun getModule(module: String, locale: Locale): ResourceBundle? =
        try {
            ResourceBundle.getBundle("locales/$module", locale.asJavaLocale())
        } catch (exception: MissingResourceException) {
            logger.warn { "Couldn't get resource bundle \"$module\" for locale \"$locale\"" }
            null
        }

    override fun supportsLocale(locale: Locale, module: String): Boolean =
        supportedLocales.contains(locale)

    override fun translate(key: String, vararg replaceWith: Any, locale: Locale, module: String): String {
        val l = if (supportsLocale(locale, module)) locale else defaultLocale

        logger.trace { "Fetching key \"$key\" locale \"$l\" and module \"$module\"" }
        val m = getModule(module, l)
        if (m == null) {
            logger.warn { "Translation module not found \"$module\"" }
            return key
        }

        return format(
            try {
                m.getString(key)
            } catch (e: MissingResourceException) {
                key
            },
            *replaceWith
        )
    }

    override fun getAllStrings(key: String, module: String): Map<Locale, String> =
        supportedLocales.associateWith { translate(key, locale = it, module = module) }
}

fun translate(key: String, vararg replaceWith: Any): String = ResourceProvider().translate(key, replaceWith)

