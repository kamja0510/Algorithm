package baekjoon.barkingdog.basicCode

import java.io.*
import java.util.*

/**
 * Reads two integers from standard input, calculates their sum, and writes the result to standard output.
 *
 * Expects a single line of input containing two space-separated integers.
 */
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