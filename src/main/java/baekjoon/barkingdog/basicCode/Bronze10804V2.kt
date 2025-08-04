package baekjoon.barkingdog.basicCode

import java.util.*

fun main(){
    val numbers = IntArray(21){ index -> index }
    for(i in 0..9){
        val st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val tempStack = Stack<Int>()
        for(j in start .. end){
            tempStack.push(numbers[j])
        }
        for(j in start .. end){
            numbers[j] = tempStack.pop()
        }
    }

    val bw = System.`out`.bufferedWriter()

    for(i in 1..20){
        bw.write("${numbers[i]} ")
    }
    bw.close()
}
// 12824KB 92ms