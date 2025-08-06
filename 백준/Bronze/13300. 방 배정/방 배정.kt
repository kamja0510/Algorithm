package baekjoon.barkingdog.array

import java.util.StringTokenizer
import kotlin.math.ceil

fun main(){
    System.`in`.bufferedReader().use{ br->
        var st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val capacity = st.nextToken().toFloat()

        val peopleTable = Array(2){ IntArray(6) }
        var numberOfRoom = 0

        repeat(n){
            st = StringTokenizer(readln())
            val sex = st.nextToken().toInt()
            val grade = st.nextToken().toInt()
            peopleTable[sex][grade-1]++
        }

        peopleTable.forEach {
            it.forEach { numberOfPerson ->
                numberOfRoom += ceil(numberOfPerson / capacity).toInt()
            }
        }

        print(numberOfRoom)
    }
}