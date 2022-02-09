package myosyn.nabi.extensions.tags

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand

class Tags : Extension() {
    override val name: String = "tags"

    override suspend fun setup() {
        publicSlashCommand(::TagsArguments) {
            name = "tags"
            description = ""

        }
    }
    inner class TagsArguments : Arguments() {
        val name by string {
            name = "name"
            description = ""
        }
    }
}