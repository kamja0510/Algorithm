package baekjoon.barkingdog.deque

fun main() {
    val (sizeOfQueue, numberOfExtracting) = readln().split(" ").map{ it.toInt() }
    val locationOfExtracting = readln().split(" ").map{ it.toInt() }

    val circularQueue = ArrayDeque<Int>(sizeOfQueue).apply {
        for (i in 1..sizeOfQueue) addLast(i)
    }
    var answer = 0

    fun rotateLeft() { circularQueue.addLast(circularQueue.removeFirst()) }
    fun rotateRight() { circularQueue.addFirst(circularQueue.removeLast()) }

    for (location in locationOfExtracting) {
        val index = circularQueue.indexOf(location)
        val left = index
        val right = circularQueue.size - index

        if (left <= right) {
            repeat(left) {
                rotateLeft()
                answer++
            }
        } else {
            repeat(right) {
                rotateRight()
                answer++
            }
        }

        circularQueue.removeFirst()
    }
    println(answer)
}