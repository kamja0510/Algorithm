package baekjoon.barkingdog.twopointer

import kotlin.math.min

fun main(){
    val (n, m) = readln().split(" ").map{ it.toInt() }
    val numbers = List<Int>(n){ readln().toInt() }.sorted()
    var start = 0
    var end = 0
    var answer = Int.MAX_VALUE

    while(end in start..<n){
        val diff = numbers[end] - numbers[start]
        if(diff > m){
            answer = min(answer, diff)
            start++
        }else if(diff < m){
            end++
        }else{
            answer = m
            break
        }
    }

    print(answer)
}