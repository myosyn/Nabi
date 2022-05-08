package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.Image
import dev.kord.rest.builder.message.create.embed

class UserCommand : Extension() {
    override val name: String = "User"

    override suspend fun setup() {
        publicSlashCommand(::UserArguments) {
            name = "User"
            description = "Looks up a user."

            check {
                anyGuild()
            }

            action {
                val target = arguments.userArgs ?: this.user.asUser()
                val userBanner = user.withStrategy(EntitySupplyStrategy.rest).fetchUser().getBannerUrl(Image.Format.JPEG)
                val userProfilePicture = user.withStrategy(EntitySupplyStrategy.rest).fetchUser().defaultAvatar
                val discordNitro =

                respond {
                    embed {

                    }
                }
            }
        }
    }
    inner class UserArguments : Arguments() {
        val userArgs by optionalUser {
            name = "User"
            description = "Searches up a user. If left blank, defaults to you"
        }
    }
}