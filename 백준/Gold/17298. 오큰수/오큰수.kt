package baekjoon.barkingdog.stack

fun main() {
    val n = readln().toInt()

    val sequence = readln().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()
    val answer = IntArray(sequence.size)

    for(i in n-1 downTo 0){
        while(stack.isNotEmpty() && stack.last() <= sequence[i] ){
            stack.removeLast()
        }
        if(stack.isEmpty()) answer[i] = -1 else answer[i] = stack.last()
        stack.addLast(sequence[i])
    }
    print(answer.joinToString(" "))
}