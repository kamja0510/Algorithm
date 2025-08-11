package baekjoon.barkingdog.stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val stack = ArrayDeque<Int>()
    var answer = 0L

    repeat(n) {
        val h = br.readLine().toInt()
        while (stack.isNotEmpty() && stack.last() <= h) stack.removeLast()
        answer += stack.size
        stack.addLast(h)
    }
    print(answer)
}