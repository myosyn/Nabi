package dev.myosyn.nabi.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.Image
import dev.kord.rest.builder.message.create.embed

class ServerCommand : Extension() {
    override val name: String = "Server"

    override suspend fun setup() {
        publicSlashCommand {
            name = "Server"
            description = "Shows the information of the Discord Server you're currently in."

            check {
                anyGuild()
            }

            action {
                //val serverAvatar = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()
                val serverBanner = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.getBanner(Image.Format.PNG) // You literally cannot make this all for some apparent reason like ???????
                val nsfwLevel = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.nsfw
                val memberCount = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.memberCount
                val whoisOwner = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.owner
                val fetchAllRoles = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.roles
                val fetchRoleAmount = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.roleIds
                val vanityUrl = guild?.getVanityUrl()
                val premiumTier = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.premiumTier

                respond {
                    embed {
                        field {
                            name = "Owner of the Server"
                            value = whoisOwner.toString()
                        }
                        field {
                            name = "**>> About**"
                            value = whoisOwner.toString()
                            name = "**>> Member Count: [${memberCount}] **"
                            name = "**>> Nitro Boost Level: [${premiumTier}]**"
                            name = "**>> NSFW Level: [${nsfwLevel}]**"
                            inline = true
                            name = "**>> Roles: [] **"
                            value = fetchAllRoles.toString()
                            inline = true
                            name = "****"
                        }
                        thumbnail {

                        }
                    }
                }
            }
        }
    }
}