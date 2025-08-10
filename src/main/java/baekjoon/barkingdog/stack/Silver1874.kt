package baekjoon.barkingdog.stack

fun main() {
    val numberOfElement = readln().toInt()
    val stack = IntArray(numberOfElement)
    var top = -1
    var number = 1
    val result = buildString {
        repeat(numberOfElement) {
            val n = readln().toInt()
            while(top < 0 || stack[top] < n){
                stack[top+1] = number
                top++
                number++
                appendLine("+")
            }
            if(stack[top] > n) {
                clear()
                appendLine("NO")
                return@buildString
            }
            top--
            appendLine("-")
        }
    }
    println(result)
}