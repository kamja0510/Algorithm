package baekjoon.barkingdog.greedy

import java.util.StringTokenizer

fun main(){
    val n = readln().toInt()

    val meetings = List<Meeting>(n){
        val st = StringTokenizer(readln())
        Meeting(
            st.nextToken().toInt(),
            st.nextToken().toInt()
        )
    }.sorted()

    var prev: Meeting = meetings[0]
    var answer = 1
    
    for(i in 1..<n){
        if(meetings[i].start >= prev.end){
            answer++
            prev = meetings[i]
        }
    }
    
    println(answer)
}

data class Meeting(val start: Int, val end: Int) : Comparable<Meeting>{
    override fun compareTo(other: Meeting): Int {
        return if(this.end == other.end){
            this.start - other.start
        }else{
            this.end - other.end
        }
    }
}