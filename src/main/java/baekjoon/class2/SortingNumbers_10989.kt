package baekjoon.class2

import java.io.*

fun main(args : Array<String>){
    val numOfNumbers = readln().toInt()
    val numbers = IntArray(10001)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    for(i in 0 until numOfNumbers){
        numbers[br.readLine().toInt()]++
    }
    for(i in 0..10000){
        bw.write("$i\n".repeat(numbers[i]))
    }
    bw.close()
}