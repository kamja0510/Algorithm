package baekjoon.barkingdog.dp

fun main(){
    val (n, k) = readln().split(" ").map{ it.toInt() }
    val dp = Array(n + 1) { Array(n+ 1) { 0 } }

    for(i in 1..n){
        dp[i][0] = 1
        dp[i][i] = 1
        for(j in 1..<i){
            dp[i][j] = (dp[i - 1][j ] + dp[i-1][j - 1]) % 10007
        }
    }
    println(dp[n][k])
}