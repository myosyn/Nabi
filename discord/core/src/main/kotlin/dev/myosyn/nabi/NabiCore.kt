package dev.myosyn.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.PresenceStatus

import dev.myosyn.nabi.developer.*
import dev.myosyn.nabi.general.*
import dev.myosyn.nabi.moderation.*
import dev.myosyn.nabi.test.*

suspend fun main() {
    var bot = ExtensibleBot(env("TOKEN")) {
        extensions {

            // Yes, I know I could've done this in a better way, but to be honest, I don't care.

            // Developer directory
            add(::BotBlacklistCommand)
            add(::EvalCommand)

            // General directory
            add(::InfoCommand)
            add(::UserCommand)

            // Moderation directory
            add(::BanCommand)
            add(::LockChannelCommand)
            add(::RemoveTimeoutCommand)
            add(::TemporaryBanCommand)
            add(::TimeoutCommand)
            add(::UnbanCommand)
            add(::UnlockChannelCommand)
            add(::WarnCommand)

            // Test directory
            add(::TestEmbed)
            add(::TestFailCommand)
            add(::TestMessaging)
            add(::TestSuccessCommand)
        }

        presence {
            status = PresenceStatus.Online
        }
    }
}