package dev.myosyn.nabi.user

import com.kotlindiscord.kord.extensions.checks.failed
import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import dev.kord.core.entity.User
import dev.kord.core.event.Event
import mu.KotlinLogging

suspend fun <T : Event> CheckContext<T>.CheckSpecificUser(user: User) {
    if (!passed) {
        return
    }

    val logger = KotlinLogging.logger("dev.myosyn.nabi.user.CheckSpecifiedUser")
    val targetUser = user.asUser().id

    when(user.id) {
        else -> {
            logger.failed("Member wasn't the owner of the bot. Throwing Exception.")
            fail(translate("checks.checkSpecificUser.fail"))
        }
    }
}