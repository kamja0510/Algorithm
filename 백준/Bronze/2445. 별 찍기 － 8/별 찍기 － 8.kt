package baekjoon.barkingdog.basicCode

fun main() {
    val n = readln().toInt()

    val result = buildString {
        for(i in 1..n){
            repeat(i){ append('*') }
            repeat(2*n - 2*i ){ append(' ') }
            repeat(i){ append('*') }
            appendLine()
        }
        for(i in n-1 downTo 1){
            repeat(i){ append('*') }
            repeat(2*n - 2*i ){ append(' ') }
            repeat(i){ append('*') }
            appendLine()
        }
    }

    print(result)
}