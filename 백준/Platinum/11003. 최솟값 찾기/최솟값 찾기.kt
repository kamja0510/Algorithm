package baekjoon.barkingdog.deque

import java.util.StringTokenizer

data class Node(val index: Int, val value: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (sequenceSize, windowSize) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val bw = System.out.bufferedWriter()

    val deque = ArrayDeque<Node>()

    repeat(sequenceSize) { index ->
        val value = st.nextToken().toInt()
        if (deque.isNotEmpty() && deque.first().index <= index - windowSize) {
            deque.removeFirst()
        }
        while (deque.isNotEmpty() && deque.last().value >= value) {
            deque.removeLast()
        }
        deque.addLast(Node(index = index, value = value))
        bw.write(deque.first().value.toString())
        bw.write(" ")
    }

    bw.flush()
    bw.close()
}
