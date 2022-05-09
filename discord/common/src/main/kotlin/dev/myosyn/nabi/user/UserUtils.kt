package dev.myosyn.nabi

import dev.kord.core.entity.User
import dev.kord.rest.Image
import dev.myosyn.nabi.guild.imageFormatter

fun User.userAvatarFormatting(size: Image.Size? = Image.Size.Size128): String {
    return avatar?.cdnUrl?.toUrl {
        this.format = if (avatar?.animated == true) Image.Format.GIF else Image.Format.PNG
    } ?: defaultAvatar.cdnUrl.toUrl {
        this.format = Image.Format.PNG
    }
}

fun User.userBannerFormatting(size: Image.Size? = Image.Size.Size2048): String? {
    val hash = data.banner ?: return null
    val format = imageFormatter(hash)
    return getBannerUrl(format) + size?.let{ "?size=${size.maxRes}" }
}