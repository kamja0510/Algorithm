package baekjoon.barkingdog.queue

fun main(){
    val numberOfCommands = readln().toInt()
    val queue = ArrayDeque<Int>()
    val result = buildString {
        repeat(numberOfCommands){
            val command = readln().split(" ")
            when(command[0]){
                "push" -> queue.addLast(command[1].toInt())
                "pop" -> if(queue.isNotEmpty()) appendLine(queue.removeFirst()) else appendLine(-1)
                "size" -> appendLine(queue.size)
                "empty" -> appendLine(if(queue.isEmpty()) 1 else 0)
                "front" -> appendLine(if(queue.isNotEmpty()) queue.first() else -1)
                "back" -> appendLine(if(queue.isNotEmpty()) queue.last() else -1)
            }
        }
    }
    print(result)
}