package baekjoon.barkingdog.queue

fun main(){
    val numberOfCommands = readln().toInt()
    val queue = ArrayDeque<Int>()
    repeat(numberOfCommands){
        val command = readln().split(" ")
        when(command[0]){
            "push" -> queue.addLast(command[1].toInt())
            "pop" -> if(queue.isNotEmpty()) println(queue.removeFirst()) else println("-1")
            "size" -> println(queue.size)
            "empty" -> println(if(queue.isEmpty()) 1 else 0)
            "front" -> println(if(queue.isNotEmpty()) queue.first() else "-1")
            "back" -> println(if(queue.isNotEmpty()) queue.last() else "-1")
        }
    }
}