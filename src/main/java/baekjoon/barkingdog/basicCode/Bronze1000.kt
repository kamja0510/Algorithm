package baekjoon.barkingdog.basicCode

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val st = StringTokenizer(br.readLine())
    var sum = 0
    repeat(2){
        sum += st.nextToken().toInt()
    }

    bw.write(sum.toString())
    bw.flush()
}