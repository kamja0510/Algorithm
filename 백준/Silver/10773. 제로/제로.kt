package baekjoon.barkingdog.stack

fun main() {
    val k = readln().toInt()
    val stack = ArrayDeque<Int>()
    repeat(k){
        val money = readln().toInt()
        if(money == 0) stack.removeLast() else stack.addLast(money)
    }
    println(stack.sum())
}