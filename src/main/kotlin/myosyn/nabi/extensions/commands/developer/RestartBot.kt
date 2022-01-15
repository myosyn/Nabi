package myosyn.nabi.extensions.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class RestartBot : Extension() {
    override val name = "restart"

    override suspend fun setup() {

        ephemeralSlashCommand(::RestartBot) {
            name = "restart"
            description = "Restarts the entire bot."

            allowUser(Snowflake(OWNER_ID))
        }
    }
}