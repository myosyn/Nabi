package live.shuuyu.nabi.kord.utils

fun Long.formatMemory(): String {
    val kb = this / 1024L
    val mb = kb / 1024L
    val gb = mb / 1024L

    return when {
        kb < 1024 -> "${kb}KB"
        mb < 1024 -> "${mb}MB"
        else -> "${gb}GB"
    }
}