package baekjoon.barkingdog.dp

fun main(){
    val n = readln().toInt()
    when(n){
        1 -> {
            println(0)
            return
        }
        2 -> {
            println(1)
            return
        }
        3 -> {
            println(1)
            return
        }
    }

    val dp = IntArray(n+1){0}
    dp[1] = 0
    dp[2] = 1
    dp[3] = 1

    for(i in 4..n){
        dp[i] = dp[i-1] + 1
        if(i % 2 == 0){
            dp[i] = minOf(dp[i/2]  + 1, dp[i])
        }
        if(i % 3 == 0){
            dp[i] = minOf(dp[i/3]  + 1, dp[i])
        }
    }

    println(dp[n])
}