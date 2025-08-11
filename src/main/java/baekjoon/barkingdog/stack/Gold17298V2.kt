package baekjoon.barkingdog.stack

fun main(){
    val n = readln().toInt()

    val sequence = readln().split(" ").map { it.toInt() }
    val answer = IntArray(n) { -1 }
    val stack = ArrayDeque<Int>()

    for (i in 0 until n) {
        while (stack.isNotEmpty() && sequence[stack.last()] < sequence[i]) {
            answer[stack.removeLast()] = sequence[i]
        }
        stack.addLast(i)
    }
    while (stack.isNotEmpty()) {
        answer[stack.removeLast()] = -1
    }

    println(answer.joinToString(" "))
}