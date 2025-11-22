package baekjoon.barkingdog.dp

fun main(){
    val n = readln().toInt()

    when(n){
        1 -> {
            println(1)
            return
        }
        2 -> {
            println(2)
            return
        }
    }

    val dp = IntArray(n+1){0}
    dp[1] = 1
    dp[2] = 2
    for(i in 3..n){
        dp[i] = dp[i-1] + dp[i-2]
        dp[i] %= 10007
    }

    println(dp[n])
}