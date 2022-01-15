package myosyn.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.PresenceStatus
import dev.kord.common.entity.Snowflake
import endeavor.nabi.commands.moderation.utils.OWNER_ID

class SetRPC : Extension() {
    private val presenceArgument: String
    override val name = "setrpc"

    override suspend fun setup() {

        ephemeralSlashCommand(::SetRPC) {
            name = "setrpc"
            description = "Sets the RPC that is displayed in Nabi's RPC"

            allowUser(Snowflake(OWNER_ID))

            action {
                this@ephemeralSlashCommand.kord.editPresence {
                    status = PresenceStatus.Online
                    playing(arguments.presenceArgument)
                }

                respond { content = "Presence has been set to `${arguments.presenceArgument}`" }

                ResponseHelper.responseEmbedInChannel(
                    actionLog,
                    "Presence Changed",
                    "Nabi's Rich Presence has been set to "
                )
            }
        }
    }
}