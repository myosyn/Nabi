package dev.myosyn.nabi.user

import com.kotlindiscord.kord.extensions.i18n.TranslationsProvider
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.create.FollowupMessageCreateBuilder
import dev.kord.rest.builder.message.create.embed

fun FollowupMessageCreateBuilder.avatarEmbed(translationsProvider: TranslationsProvider, target: User) {
    embed {

    }
}