package baekjoon.barkingdog.linkedList

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val list = MutableList(n) { it + 1 }

    val answer = mutableListOf<Int>()

    var index = 0
    while (list.isNotEmpty()) {
        index = (index + k - 1) % list.size
        answer.add(list.removeAt(index))
    }

    println("<${answer.joinToString()}>")
}