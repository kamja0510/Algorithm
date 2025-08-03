package baekjoon.barkingdog.basicCode

import java.util.StringTokenizer

fun main() {
    val numberOfCall = readln().toInt()
    val st = StringTokenizer(readln())
    var YFee = 0
    var MFee = 0
    while(st.hasMoreTokens()){
        val timeOfCall = st.nextToken().toInt()
        YFee += (timeOfCall/30 + 1) * 10
        MFee += (timeOfCall/60 + 1) * 15
    }
    when{
        YFee < MFee -> println("Y $YFee")
        MFee < YFee -> println("M $MFee")
        else -> println("Y M $YFee")
    }
}