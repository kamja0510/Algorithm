package baekjoon.barkingdog.dp

fun main(){
    val n = readln().toInt()
    val fee = Array(n){
        readln().split(" ").map{it.toInt()}
    }

    val dp = Array(n){ IntArray(3) }
    dp[0][0] = fee[0][0]
    dp[0][1] = fee[0][1]
    dp[0][2] = fee[0][2]

    for(i in 1 until n){
        dp[i][0] = minOf(dp[i-1][1], dp[i-1][2]) + fee[i][0]
        dp[i][1] = minOf(dp[i-1][0], dp[i-1][2]) + fee[i][1]
        dp[i][2] = minOf(dp[i-1][0], dp[i-1][1]) + fee[i][2]
    }

    println(minOf(dp[n-1][0], dp[n-1][1], dp[n-1][2]))
}