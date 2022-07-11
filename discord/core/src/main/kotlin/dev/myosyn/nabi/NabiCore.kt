package dev.myosyn.nabi

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordPreview
import dev.kord.common.entity.PresenceStatus
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.myosyn.nabi.developer.BotBlacklistCommand
import dev.myosyn.nabi.developer.EvalCommand
import dev.myosyn.nabi.developer.ShutdownCommand
import dev.myosyn.nabi.general.*
import dev.myosyn.nabi.moderation.*
import dev.myosyn.nabi.myosyn.EuphoriaDownload
import dev.myosyn.nabi.myosyn.GetOffOfFeatherClient
import dev.myosyn.nabi.setchannels.SetLeaveChannelCommand
import dev.myosyn.nabi.setchannels.SetModerationLoggingChannelCommand
import dev.myosyn.nabi.setchannels.SetSuggestionChannelCommand
import dev.myosyn.nabi.setchannels.SetWelcomeChannelCommand
import dev.myosyn.nabi.suggestion.SuggestionCommand
import dev.myosyn.nabi.tags.TagsCommand
import dev.myosyn.nabi.test.TestEmbed
import dev.myosyn.nabi.test.TestFailCommand
import dev.myosyn.nabi.test.TestMessaging
import dev.myosyn.nabi.test.TestSuccessCommand

@OptIn(KordExperimental::class, PrivilegedIntent::class, KordPreview::class)
suspend fun main() {
    val bot = ExtensibleBot(env(NABI_TOKEN)) {

        applicationCommands {
            enabled = true
        }

        intents {
            +Intent.DirectMessages
            +Intent.DirectMessageTyping
            +Intent.Guilds
            +Intent.GuildMembers
            +Intent.GuildMessages
            +Intent.GuildEmojis
            +Intent.GuildBans
            +Intent.GuildMessageReactions
            +Intent.GuildInvites
            +Intent.GuildPresences
            +Intent.GuildWebhooks
        }

        extensions {
            // Yes, I know I could've done this in a better way, but to be honest, I don't care.

            // Developer directory
            add(::BotBlacklistCommand)
            add(::EvalCommand)
            add(::ShutdownCommand)

            // General directory
            add(::AvatarCommand)
            add(::BotInfoCommand)
            add(::GuildInfoCommand)
            add(::ServerCommand)
            add(::UserCommand)

            // Github directory

            // Moderation directory
            add(::BanCommand)
            add(::KickCommand)
            add(::LockChannelCommand)
            add(::PurgeCommand)
            add(::RemoveTimeoutCommand)
            add(::RoleCommand)
            add(::SlowModeCommand)
            add(::TemporaryBanCommand)
            add(::TimeoutCommand)
            add(::UnbanCommand)
            add(::UnlockChannelCommand)
            add(::WarnCommand)

            // Myosyn specific commands
            add(::EuphoriaDownload)
            add(::GetOffOfFeatherClient)

            // SetChannels directory
            add(::SetLeaveChannelCommand)
            add(::SetModerationLoggingChannelCommand)
            add(::SetSuggestionChannelCommand)
            add(::SetWelcomeChannelCommand)

            // Suggestions
            add(::SuggestionCommand)

            add(::TagsCommand)

            // Test directory
            add(::TestEmbed)
            add(::TestFailCommand)
            add(::TestMessaging)
            add(::TestSuccessCommand)
        }

        presence {
            status = PresenceStatus.DoNotDisturb
            playing("In the moonlight skies")
        }
    }
    bot.start()
}