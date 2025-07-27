package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
    while(true){
        val line = readlnOrNull() ?: break
        val st = StringTokenizer(line)
        println(st.nextToken().toInt() + st.nextToken().toInt())
    }
}