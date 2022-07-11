package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.annotation.KordExperimental
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import dev.myosyn.nabi.embeds.ColorUtils.DEFAULT_COLOR
import dev.myosyn.nabi.guild.guildAvatarData
import dev.myosyn.nabi.guild.guildBannerData
import dev.myosyn.nabi.guild.guildSplashData
import kotlinx.datetime.Clock

@KordExperimental
class AvatarCommand : Extension() {
    override val name: String = "Avatar"

    override suspend fun setup() {
        publicSlashCommand(::AvatarArguments) {
            name = "avatar"
            description = "Displays the specified user's avatar. If left blank, it defaults to you."

            check {
                anyGuild()
            }

            action {
                val target = arguments.userArguments ?: this.user.asUser()
                val iconImage = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.guildAvatarData()
                val bannerImage = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.guildBannerData()
                val splashImage = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.guildSplashData()

                respond {
                    embed {
                        field {
                            name = "**User** >>> $target"
                        }
                        color = DEFAULT_COLOR
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class AvatarArguments : Arguments() {
        val userArguments by optionalUser {
            name = "user"
            description = "The user you want to look up."
        }
    }
}