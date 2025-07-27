package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val t = br.readLine().toInt()
//
//    repeat(t){
//        val st = StringTokenizer(br.readLine())
//        println(st.nextToken().toInt() + st.nextToken().toInt())
//    }
    val t = readln().toInt()
    repeat(t){
        val st = StringTokenizer(readln())
        println(st.nextToken().toInt() + st.nextToken().toInt())
    }
}