package dev.myosyn.nabi.user

import com.kotlindiscord.kord.extensions.utils.dm
import dev.kord.common.Color
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.ERROR_COLOR
import kotlinx.datetime.Clock

object UserDm {

    /*
    Taken from LilyBot, licensed under the GPL-3.0 license
     */
    suspend fun dmUser(user: User, embedTitle: String?, embedDescription: String?, embedColor: Color?) = user.dm  {
        embed {
            title = embedTitle
            description = embedDescription
            color = embedColor ?: ERROR_COLOR
            timestamp = Clock.System.now()
        }
    }
}