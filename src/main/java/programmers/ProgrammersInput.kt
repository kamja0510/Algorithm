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

fun String.to2DIntArray(): Array<IntArray> {
    val content = this.trim()
    if (content == "[]" || content == "[[]]") return emptyArray()

    return content
        .removeSurrounding("[", "]") // 가장 바깥쪽 [ ] 제거
        .split("],")                 // 행 단위 분리 (닫는 대괄호와 콤마 기준)
        .map { rowString ->
            rowString
                .replace("[", "")    // 남은 여는 대괄호 제거
                .replace("]", "")    // 남은 닫는 대괄호 제거 (마지막 원소 처리용)
                .split(",")          // 숫자 단위 분리
                .map { it.trim().toInt() }
                .toIntArray()
        }
        .toTypedArray()
}