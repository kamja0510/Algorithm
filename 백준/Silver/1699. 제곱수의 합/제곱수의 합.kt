package baekjoon

fun main(){
    val n = readln().toInt()
    val dp = IntArray(n+1){ Int.MAX_VALUE }
    dp[0] = 0
    for(i in 1..n){
        for(j in 1..kotlin.math.sqrt(i.toFloat()).toInt()){
            dp[i] = minOf(dp[i], dp[i-j*j] + 1)
        }
    }
    println(dp[n])
}