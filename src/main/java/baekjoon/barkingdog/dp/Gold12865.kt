package baekjoon.barkingdog.dp

fun main(){
    val (n, k) = readln().split(" ").map{it.toInt()}
    val w = Array(n + 1) { 0 }
    val v = Array(n + 1) { 0 }
    val dp = Array(n + 1) { Array(k+ 1) { 0 } }

    repeat(n) { idx ->
        val (iw, iv) = readln().split(" ").map { it.toInt() }
        w[idx + 1] = iw
        v[idx + 1] = iv
    }

    for(i in 1..n){
        for(j in 1..k){
            if(j - w[i] >= 0){
                dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j - w[i]] + v[i])
            } else {
                dp[i][j] = dp[i-1][j]
            }
        }
    }
    println(dp[n][k])
}