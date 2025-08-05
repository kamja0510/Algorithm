package baekjoon.barkingdog.basicCode

fun main() {
    val numberOfLine = readln().toInt()
    val result = buildString {
        for (line in 1..numberOfLine) {
            append("*".repeat(line)).appendLine()
        }
    }
    print(result)
}
// 14404KB 100ms