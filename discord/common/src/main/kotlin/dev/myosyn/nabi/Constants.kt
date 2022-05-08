package dev.myosyn.nabi

import com.kotlindiscord.kord.extensions.utils.env

val NABI_TOKEN = env("TOKEN") // Required to make the bot come online.
val MONGO_URI = env("MONGO_URI") // Required for database
val BOT_OWNER = env("BOT_OWNER")  // Required in developer directory