package baekjoon.barkingdog.bfs

fun main(){
    val (start, target) = readln().split(" ").map{ it.toInt() }
    if (start >= target) {
        println(start - target)
        return
    }
    val visit = BooleanArray(100001)
    val queue = ArrayDeque<Int>()
    var answer = 0
    var next = 0
    var prev = 0
    var squareNumber = start
    while(squareNumber!= 0 && squareNumber<100001){
        if(squareNumber == target){
            println(answer)
            return
        }
        queue.addLast(squareNumber)
        visit[squareNumber] = true
        squareNumber *= 2
    }

    if(queue.isEmpty()) queue.addLast(0)
    while(queue.isNotEmpty()){
        answer++
        repeat(queue.size){
            val current = queue.removeFirst()
            next = current+1
            while(next < 100001){
                if(next == target){
                    println(answer)
                    return
                }
                if(!visit[next]){
                    queue.addLast(next)
                    visit[next] = true
                }
                next *= 2
            }

            prev = current-1
            if(prev < 0) return@repeat
            while(prev < 100001){
                if(prev == target){
                    println(answer)
                    return
                }
                if(!visit[prev]){
                    queue.addLast(prev)
                    visit[prev] = true
                }
                prev *= 2
                if(prev == 0) break
            }
        }
    }
}