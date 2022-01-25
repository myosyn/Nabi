package myosyn.nabi.utils

import com.kotlindiscord.kord.extensions.utils.env

// Allows for easier imports of the secret magic needed
internal val DISCORD_TOKEN = env("TOKEN")

val OWNER_ID = env("OWNER_ID")
