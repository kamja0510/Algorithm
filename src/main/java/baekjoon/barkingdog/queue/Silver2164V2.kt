package baekjoon.barkingdog.queue

fun main(){
    val number = readln().toInt()
    val p = number.takeHighestOneBit()
    val ans = if (number == p) number else (number - p) shl 1
    println(ans)
}