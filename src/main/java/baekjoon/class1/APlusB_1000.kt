package baekjoon.class1

import java.io.*
import java.util.*

class APlusB_1000 {
    fun main(args:Array<String>){
//        val (first, second) = readln().split(" ").map {it.toInt() }
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        println(st.nextToken().toInt() + st.nextToken().toInt())
    }
}