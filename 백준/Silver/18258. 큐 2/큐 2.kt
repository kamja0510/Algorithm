package baekjoon.barkingdog.queue

fun main(){
    val numberOfCommand = readln().toInt()
    val queue = ArrayDeque<Int>()
    val result = buildString{
        repeat(numberOfCommand){
            val command = readln().split(" ")
            when(command[0]){
                "push" ->{
                    queue.addLast(command[1].toInt())
                }
                "pop" -> {
                    appendLine(if(queue.isNotEmpty())queue.removeFirst() else -1)
                }
                "size" -> {
                    appendLine(queue.size)
                }
                "empty" -> {
                    appendLine(if(queue.isEmpty()) 1 else 0)
                }
                "front" -> {
                    appendLine(if(queue.isEmpty()) -1 else queue.first())
                }
                "back" -> {
                    appendLine(if(queue.isEmpty()) -1 else queue.last())
                }
            }
        }
    }
    print(result)
}