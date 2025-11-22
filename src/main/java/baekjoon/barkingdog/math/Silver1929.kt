package baekjoon.barkingdog.math

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val isPrime = BooleanArray(n + 1) { true }
    isPrime[1] = false

    val limit = kotlin.math.sqrt(n.toDouble()).toInt()
    for (i in 2..limit) {
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }


    val sb = StringBuilder()
    for (i in m..n) {
        if (isPrime[i]) sb.append(i).append('\n')
    }
    print(sb.toString())
}