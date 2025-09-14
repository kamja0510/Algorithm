@file:Suppress("unused")
package baekjoon.barkingdog.deque

import kotlin.math.absoluteValue

fun main(){
    var (sizeOfQueue, _) = readln().split(" ").map{ it.toInt() }
    val orderOfExtracting = readln().split(" ").map{ it.toInt() }
    var answer = 0
    var offset = 0
    orderOfExtracting.forEach{
        val currentLocation =
            if(((it + offset) % sizeOfQueue) <= 0) sizeOfQueue + ((it + offset) % sizeOfQueue )
            else (it + offset) % sizeOfQueue
        val amount = if(sizeOfQueue - currentLocation + 1> currentLocation - 1) -(currentLocation -1) else sizeOfQueue - currentLocation + 1
        answer += amount.absoluteValue
        offset = offset + amount - 1
        sizeOfQueue --
    }
    println(answer)
}

// 실패한 코드