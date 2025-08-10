package baekjoon.barkingdog.linkedList

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val q = ArrayDeque<Int>(n).apply { for (i in 1..n) addLast(i) }
    val answer = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        // 불필요한 순회를 줄이기 위해 mod 사용
        repeat((k - 1) % q.size) {
            q.addLast(q.removeFirst())
        }
        answer.add(q.removeFirst())
    }

    println("<${answer.joinToString()}>")
}