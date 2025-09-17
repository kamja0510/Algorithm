package baekjoon.barkingdog.bfs

fun main() {
    data class Node(
        val location: Int,
        val spendingTime: Int,
    )
    val (start, target) = readln().split(" ").map{ it.toInt() }
    var answer = 0
    val queue = ArrayDeque<Node>()
    val visit = BooleanArray(150001)
    queue.addLast(Node(location = start, spendingTime = 0))
    visit[start] = true
    while(queue.isNotEmpty()){
        val current = queue.removeFirst()
        if(current.location +1 <= target && !visit[current.location + 1]) {
            if(current.location + 1 == target) {
                answer = current.spendingTime + 1
                break
            }
            queue.addLast(Node(current.location +1, current.spendingTime+1))
            visit[current.location + 1] = true
        }
        if(current.location -1 >= 0 && !visit[current.location - 1]) {
            if(current.location - 1 == target) {
                answer = current.spendingTime + 1
                break
            }
            queue.addLast(Node(current.location -1, current.spendingTime+1))
            visit[current.location-1] = true

        }
        if(current.location * 2 <=150000 && !visit[current.location * 2]) {
            if(current.location * 2 == target) {
                answer = current.spendingTime + 1
                break
            }
            queue.addLast(Node(current.location * 2, current.spendingTime+1))
            visit[current.location * 2] = true
        }
    }
    println(answer)
}
