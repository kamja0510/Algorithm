package baekjoon.barkingdog.basicCode

import java.util.*
import kotlin.math.*

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    if(a == b) println(0)
    else{
        println((b-a).absoluteValue-1)
        println((min(a,b)+1..<max(a,b)).joinToString(" "))
    }
}