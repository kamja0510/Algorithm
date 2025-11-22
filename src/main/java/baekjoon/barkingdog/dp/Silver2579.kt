package baekjoon.barkingdog.dp

fun main(){
    val n = readln().toInt()
    val stairs = List(n){readln().toInt()}

    if(n == 1){
        println(stairs[0])
        return
    }else if(n == 2){
        println(stairs[0] + stairs[1])
        return
    }

    val dp = List(n){
        IntArray(2){0}
    }

    dp[0][0] = stairs[0]
    dp[0][1] = stairs[0]
    dp[1][0] = stairs[1]
    dp[1][1] = stairs[0] + stairs[1]

    for(i in 2 until n){
        dp[i][0] = maxOf(dp[i-2][0], dp[i-2][1]) + stairs[i]
        dp[i][1] = dp[i-1][0] + stairs[i]
    }

    println(maxOf(dp[n-1][0], dp[n-1][1]))
}