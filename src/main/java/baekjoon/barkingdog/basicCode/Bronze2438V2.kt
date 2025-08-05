package baekjoon.barkingdog.basicCode

fun main() {
    val numberOfLines = readln().toInt()
    print((1..numberOfLines).joinToString("\n") { "*".repeat(it) })
}
// 22072KB 132ms