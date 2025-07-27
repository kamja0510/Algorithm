package baekjoon.problems8708

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toInt() - 1
    var answer = 1
    while(number > 0){
        number -= answer * 6
        answer++
    }
    println(answer)
}