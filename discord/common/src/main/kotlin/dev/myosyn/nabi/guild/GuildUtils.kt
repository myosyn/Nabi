package dev.myosyn.nabi.guild

import dev.kord.core.entity.Guild
import dev.kord.rest.Image

/*
 * @returns the banner data for the guild
 */
fun Guild.guildBannerData(size: Image.Size? = Image.Size.Size2048): String? {
    val hash = data.icon ?: return null
    val format = imageFormatter(hash)
    return getBannerUrl(format) + size?.let { "?size=${size.maxRes}}" }
}

fun Guild.guildAvatarData(size: Image.Size? = Image.Size.Size2048): String? {
    val hash = data.icon ?: return null
    val format = imageFormatter(hash)
    return getIconUrl(format) + size?.let { "?size=${size.maxRes}}" }
}

/*
 * @returns the server icon data for the guild
 */
fun Guild.guildSplashData(size: Image.Size? = Image.Size.Size2048): String? {
    val hash = data.icon ?: return null
    val format = imageFormatter(hash)
    return getSplashUrl(format) + size?.let { "?size=${size.maxRes}" }
}

/*
 * @returns the discovery icon data for the guild
 */

fun Guild.discoveryData(size: Image.Size? = Image.Size.Size2048): String? {
    val hash = data.icon ?: return null
    val format = imageFormatter(hash)
    return getDiscoverySplashUrl(format) + size?.let { "?size=${size.maxRes}" }
}

fun imageFormatter(hash: String) = if (hash.startsWith("a_")) Image.Format.GIF else Image.Format.PNG