package baekjoon.barkingdog.stack

import java.util.*

fun main() {
    val numberOfCommands = readln().toInt()

    val stack = Stack<Int>()
    
    buildString {
        repeat(numberOfCommands){
            val command = readln().split(" ")

            when(command[0]){
                "push" ->{
                    stack.push(command[1].toInt())
                }
                "pop" -> {
                    if(stack.isEmpty()) appendLine(-1) else appendLine(stack.pop())
                }
                "size" -> {
                    appendLine(stack.size)
                }
                "empty" -> {
                    if(stack.isEmpty()) appendLine(1) else appendLine(0)
                }
                "top" -> {
                    if(stack.isEmpty()) appendLine(-1) else appendLine(stack.peek())
                }
            }
        }
    }.run { print(this) }
}