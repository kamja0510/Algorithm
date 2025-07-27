package baekjoon.class1

import java.io.*
import java.util.*


    fun main(args:Array<String>){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())

        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if(a > b) println(">")
        else if(a < b) println("<")
        else println("==")
    }