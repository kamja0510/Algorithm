package baekjoon.barkingdog.stack

fun main() {
    val numberOfCommands = readln().toInt()

    val stack = ArrayDeque<Int>()

    buildString {
        repeat(numberOfCommands){
            val command = readln().split(" ")

            when(command[0]){
                "push" ->{
                    stack.addLast(command[1].toInt())
                }
                "pop" -> {
                    if(stack.isEmpty()) appendLine(-1) else appendLine(stack.removeLast())
                }
                "size" -> {
                    appendLine(stack.size)
                }
                "empty" -> {
                    if(stack.isEmpty()) appendLine(1) else appendLine(0)
                }
                "top" -> {
                    if(stack.isEmpty()) appendLine(-1) else appendLine(stack.last())
                }
            }
        }
    }.run { print(this) }
}