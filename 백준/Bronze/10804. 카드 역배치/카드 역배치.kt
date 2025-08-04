package baekjoon.barkingdog.basicCode

import java.util.*

fun main(){
    val numbers = IntArray(21){ index -> index }
    for(i in 0..9){
        val st = StringTokenizer(readln())
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        while(start < end){
            numbers[start] = numbers[end].also { numbers[end] = numbers[start] }
            start++
            end--
        }
    }

    val bw = System.`out`.bufferedWriter()

    for(i in 1..20){
        bw.write("${numbers[i]} ")
    }
    bw.close()
}