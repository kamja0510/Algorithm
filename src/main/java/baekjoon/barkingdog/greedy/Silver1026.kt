package baekjoon.barkingdog.greedy

fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map{ it.toInt() }.sorted()
    val b = readln().split(" ").map{ it.toInt() }.sorted()

    var sum = 0
    repeat(n){ index ->
        sum += a[index] * b[n - index - 1]
    }

    println(sum)
}