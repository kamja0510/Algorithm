package baekjoon.barkingdog.basicCode

fun main() {
    val oddNumbers = generateSequence { readln().toInt() }
        .take(7)
        .filter { it % 2 == 1 }
        .toList()

    if (oddNumbers.isEmpty()) {
        println(-1)
    } else {
        println(oddNumbers.sum())
        println(oddNumbers.minOrNull())
    }
}
// 20888KB, 136MS