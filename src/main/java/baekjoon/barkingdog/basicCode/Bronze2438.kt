package baekjoon.barkingdog.basicCode

fun main() {
    val numberOfLine = readln().toInt()
    val result = buildString {
        for (line in 1..numberOfLine) {
            repeat(line) {
                append("*")
            }
            appendLine()
        }
    }
    print(result)
}