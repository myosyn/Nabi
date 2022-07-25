package dev.myosyn.nabi

import com.kotlindiscord.kord.extensions.utils.env

object Constants {
    val NABI_TOKEN = env("TOKEN") // Required to make the bot come online.
    val DATABASE_URI = env("POSTGRES_URI") // Required for database
    val BOT_OWNER = env("BOT_OWNER")  // Required in developer directory
}
