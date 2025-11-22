package baekjoon.barkingdog.greedy

fun main(){
    val n = readln().toInt()
    val ropes = List(n){readln().toInt()}.sorted()

    var maxWeight = 0
    for(i in ropes.indices){
        maxWeight = maxOf(ropes[i] * (n-i), maxWeight)
    }

    println(maxWeight)
}