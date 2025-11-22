package baekjoon.barkingdog.dp.prefixsum

fun main(){
    val (n, m) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt() }

    val prefixSum = IntArray(n+1){0}
    for(i in 1..n){
        prefixSum[i] = prefixSum[i-1] + numbers[i-1]
    }

    repeat(m){
        val (start, end) = readln().split(" ").map{ it.toInt() }
        println((prefixSum[end] - prefixSum[start - 1]))
    }
}