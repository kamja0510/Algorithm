package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
    while(true){
        val line = readln()
        val st = StringTokenizer(line)
        val answer = st.nextToken().toInt() + st.nextToken().toInt()
        if(answer == 0) break
        println(answer)
    }
}