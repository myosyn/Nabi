package live.shuuyu.nabi.kord.utils

import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv

object Utils {
    val dotenv = dotenv()
}

fun env(name: String): String = Utils.dotenv[name]
