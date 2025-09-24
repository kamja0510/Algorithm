package baekjoon.barkingdog.recursion

import kotlin.math.pow

fun main(){
    val sb = StringBuilder()
    val level = readln().toInt()
    println((2.0.pow(level)-1).toInt())
    hanoi(level, 1, 3, 2, sb)
    println(sb.toString())
}

fun hanoi(
    level: Int,
    start: Int,
    to: Int,
    temp: Int,
    sb: StringBuilder
){
    if(level ==  1){
        sb.append(start)
        sb.append(" ")
        sb.appendLine(to)
        return
    }
    hanoi(level-1, start, temp, to, sb)
    sb.append(start).append(" ").appendLine(to)
    hanoi(level-1, temp, to, start, sb)
}