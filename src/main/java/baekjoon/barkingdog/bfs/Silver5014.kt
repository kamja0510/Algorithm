package baekjoon.barkingdog.bfs

fun main() {
    val (height, current, target, up, down) = readln().split(" ").map{ it.toInt() }
    if(current == target){ print(0); return}
    val queue = ArrayDeque<Int>()
    val visit = BooleanArray(height+1)
    queue.addLast(current)
    visit[current] = true
    var answer = 0
    while(queue.isNotEmpty()){
        answer++
        repeat(queue.size){
            val current = queue.removeFirst()
            val upStair = current + up
            if(upStair <= height && !visit[upStair]){
                if(upStair == target) {
                    println(answer)
                    return
                }
                queue.addLast(upStair)
                visit[upStair] = true
            }
            val downStair = current - down
            if(downStair >= 1 && !visit[downStair]){
                if(downStair == target){
                    println(answer)
                    return
                }
                queue.addLast(downStair)
                visit[downStair] = true
            }
        }
    }
    println("use the stairs")
}