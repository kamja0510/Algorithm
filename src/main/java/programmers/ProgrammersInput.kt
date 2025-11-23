package programmers

fun String.toIntArray(): IntArray {
    val content = this.trim()
    if (content == "[]") return intArrayOf()

    return content
        .removeSurrounding("[", "]")
        .split(",")
        .map { it.trim().toInt() }
        .toIntArray()
}

fun String.toStringArray(): Array<String> {
    val content = this.trim()
    if (content == "[]") return emptyArray()

    return content
        .removeSurrounding("[", "]")
        .split(",")
        .map {
            it.trim().removeSurrounding("\"")
        }
        .toTypedArray()
}