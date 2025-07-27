package baekjoon.problems8708

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    if(br.readLine().toInt() % 2 == 1) println("SK") else println("CY")
}

enum class Participant {
    SK, CY
}

//-1, 0, 1, 0, 1, 0,
//-1, 0, 0, 0, 1