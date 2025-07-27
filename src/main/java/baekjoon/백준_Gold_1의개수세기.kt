package baekjoon

import java.io.*
import kotlin.math.ln
import kotlin.math.pow

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (start, end) = br.readLine().split(' ').map { it.toLong() }
    println(countOne(end) - countOne(start-1))
}

// 0
// 1                                                                                2^0
// 10 11                                                                        2^1
// 100 101 110 111                                                      2^2 dp[2] = 12
// 1000 1001 1010 1011 1100 1101 1110 1111      2^3

fun countOne(number: Long): Long{
    if(number == 0L) return 0
    else if(number == 1L) return 1
    val binaryNumber = number.toString(2)
    val dpSize = (ln(number.toDouble()) / ln(2.0)).toInt()
    val dp = LongArray(dpSize)

    dp[0] = 1

    if(dpSize > 1){
        for (i in 1 until dpSize) {
            dp[i] = dp[i-1] * 2 + 2.0.pow(i).toLong()
        }
    }

    var countOne = 0L
    var countAllOne = 0L
    val length = binaryNumber.length
    binaryNumber.forEachIndexed{ index, number ->
        if(number == '1' && index < length-1){
            countAllOne += dp[length - index - 2] + countOne * 2.0.pow(length-index-1).toLong()
            countOne +=1
        }else if(number == '1' && index == length -1) {
            countAllOne += countOne
            countOne += 1
        }
    }
    countAllOne += countOne
    println(countAllOne)
    return countAllOne
}