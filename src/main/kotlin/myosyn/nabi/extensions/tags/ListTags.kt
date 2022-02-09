package myosyn.nabi.extensions.tags

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class ListTags : Extension() {
    override val name: String = "listtags"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ListTags"
            description = "Lists all of the tags that are available."
        }
    }
}