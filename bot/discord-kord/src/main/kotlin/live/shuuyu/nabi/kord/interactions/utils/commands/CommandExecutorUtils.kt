package live.shuuyu.nabi.kord.interactions.utils.commands

import live.shuuyu.nabi.kord.NabiKordCore
import live.shuuyu.nabi.kord.database.tables.BlacklistedUser
import net.perfectdreams.discordinteraktions.common.InteractionContext
import net.perfectdreams.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import net.perfectdreams.discordinteraktions.common.builder.message.embed

interface CommandExecutorUtils {
    /*

     */
    suspend fun checkIfBlacklisted(nabi: NabiKordCore, interaction: InteractionContext) {
        val blacklistedUser = BlacklistedUser.user

        interaction.sendEphemeralMessage {
            sendBlacklistEmbed()
        }
    }

    private fun InteractionOrFollowupMessageCreateBuilder.sendBlacklistEmbed() {
        embed {
            title = "You've been blacklisted"

        }
    }
}