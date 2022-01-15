package myosyn.nabi.extensions.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class MarkAffiliateServer : Extension() {
    override val name = "markaffiliateserver"

    override suspend fun setup() {
        ephemeralSlashCommand(::GuildSnowflakeArg) {
            name = "MarkAffiliateServer"
            description = "Marks a server affiliates with Nabi. They can execute more commands if they have the affiliate status."

            allowUser(Snowflake(OWNER_ID))

            action {

            }
        }
    }
}