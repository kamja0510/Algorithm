package baekjoon.problems8708

import kotlin.math.ceil

fun main() {
    val (h, w, n, m) = readln().split(" ").map{it.toInt()}
    println((ceil((h/(n+1).toDouble())) * ceil(w/(m+1).toDouble())).toInt())
}