package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
    val st = StringTokenizer(readln())
    val sb = StringBuffer()
    var hour = st.nextToken().toInt()
    var minute = st.nextToken().toInt()

    if(minute < 45){
        minute += 15
        if(hour == 0){
            hour = 23
        }else{
            hour -=1
        }
    }else{
        minute -= 45
    }

    println("$hour $minute")
}