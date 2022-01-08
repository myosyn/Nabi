package endeavor.nabi.commands.developer

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import endeavor.nabi.utils.OWNER_ID

class SetRPC : Extension() {
    override val name = "setrpc"

    override suspend fun setup() {

        ephemeralSlashCommand(::SetRPC) {
            name = "setrpc"
            description = "Sets the RPC that is displayed in Nabi's RPC"

            allowUser(OWNER_ID)

            action {
                val actionLog =
            }
        }
    }
}