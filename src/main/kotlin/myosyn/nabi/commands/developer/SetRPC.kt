package myosyn.nabi.commands.developer

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class SetRPC : Extension() {
    override val name = "setrpc"

    override suspend fun setup() {

        ephemeralSlashCommand(::SetRPC) {
            name = "setrpc"
            description = "Sets the RPC that is displayed in Nabi's RPC"

            allowUser(Snowflake(OWNER_ID))

            action {
                val actionLog =
            }
        }
    }
}