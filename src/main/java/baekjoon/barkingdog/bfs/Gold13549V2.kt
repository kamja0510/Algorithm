package baekjoon.barkingdog.bfs


fun main() {
    val (start, target) = readln().split(" ").map { it.toInt() }

    if (start >= target) {
        println(start - target)
        return
    }

    val distance = IntArray(100001) { -1 }
    val deque = ArrayDeque<Int>()

    deque.addFirst(start)
    distance[start] = 0

    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()

        if (current == target) {
            println(distance[current])
            return
        }

        var nextPos = current * 2
        if (nextPos in 0..100000 && distance[nextPos] == -1) {
            distance[nextPos] = distance[current] // 시간 증가 없음
            deque.addFirst(nextPos)
        }

        nextPos = current - 1
        if (nextPos in 0..100000 && distance[nextPos] == -1) {
            distance[nextPos] = distance[current] + 1 // 1초 증가
            deque.addLast(nextPos)
        }

        nextPos = current + 1
        if (nextPos in 0..100000 && distance[nextPos] == -1) {
            distance[nextPos] = distance[current] + 1 // 1초 증가
            deque.addLast(nextPos)
        }
    }
}