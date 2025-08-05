package baekjoon.barkingdog.basicCode

fun main() {
    val n = readln().toInt()

    val result = buildString {
        for(i in 1..n){
            repeat(n-i){ append(' ') }
            repeat(i*2-1){ append('*') }
            appendLine()
        }
    }

    print(result)
}