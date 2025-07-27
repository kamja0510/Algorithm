package baekjoon.class2

import java.util.*

fun main(args: Array<String>){
    val numOfSubjects = readln().toInt()
    val st = StringTokenizer(readln())
    val scores = IntArray(numOfSubjects)
    for(i in 0..numOfSubjects-1){
        scores[i] = st.nextToken().toInt()
    }
    val answer = scores.sum().toDouble() / scores.max() / numOfSubjects * 100
    println(answer)
}