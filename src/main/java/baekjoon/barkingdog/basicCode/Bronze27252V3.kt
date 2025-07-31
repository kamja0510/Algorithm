package baekjoon.barkingdog.basicCode

import java.util.*

fun main() {
    val input = StringTokenizer(readln())

    val nun1 = input.nextToken().toInt()
    val nun2 = input.nextToken().toInt()
    val nun3 = input.nextToken().toInt()

    val pq = PriorityQueue<Int>()
    pq.add(nun1)
    pq.add(nun2)
    pq.add(nun3)

    val result = buildString {
        append(pq.poll()).append(" ")
        append(pq.poll()).append(" ")
        append(pq.poll())
    }

    println(result)
}