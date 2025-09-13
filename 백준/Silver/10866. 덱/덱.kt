package baekjoon.barkingdog.deque

fun main(){
    val numberOfCommand = readln().toInt()
    val deque = ArrayDeque<Int>()
    val result = buildString{
        repeat(numberOfCommand){
            val command = readln().split(" ")
            when(command[0]){
                "push_front" -> { deque.addFirst(command[1].toInt()) }
                "push_back" -> { deque.addLast(command[1].toInt()) }
                "pop_front" -> { appendLine(deque.removeFirstOrNull()?:  "-1") }
                "pop_back" -> { appendLine(deque.removeLastOrNull()?: "-1") }
                "size" -> { appendLine(deque.size) }
                "empty" -> { appendLine( if(deque.isEmpty()) "1" else "0" )}
                "front" -> { appendLine( deque.firstOrNull() ?: "-1")}
                "back" -> { appendLine(deque.lastOrNull() ?: "-1")}
            }
        }
    }
    println(result)
}