package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
    var st = StringTokenizer(readln())
    val number = st.nextToken().toInt()
    val standard = st.nextToken().toInt()
    st = StringTokenizer(readln())
    val sb = StringBuffer()
    repeat(number){
        val cur = st.nextToken().toInt()
        if(cur < standard) sb.append("$cur ")
    }
    println("$sb")
}