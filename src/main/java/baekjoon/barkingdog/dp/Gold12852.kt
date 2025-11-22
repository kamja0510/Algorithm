package baekjoon.barkingdog.dp

fun main(){
    val n = readln().toInt()

    val dp = IntArray(n+1){0}
    val channel = IntArray(n+1){0}
    dp[1] = 0; channel[1] = 0

    for(i in 2..n){
        dp[i] = dp[i-1] + 1
        channel[i] = i - 1
        if(i % 2 == 0 && dp[i/2] + 1 < dp[i]){
            dp[i] = dp[i/2]  + 1
            channel[i] = i / 2
        }
        if(i % 3 == 0 && dp[i/3] + 1 < dp[i]){
            dp[i] = dp[i/3]  + 1
            channel[i] = i / 3
        }
    }

    println(dp[n])
    buildString{
        var current = n
        while(current != 0){
            append("$current ")
            current = channel[current]
        }
    }.let{print(it.trim())}
}