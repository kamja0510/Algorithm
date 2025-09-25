package baekjoon.barkingdog.backtracking

fun main(){
    val (limit, size) = readln().split(" ").map{ it.toInt() }
    val sequence = IntArray(size)
    makeSequence2(0, limit, sequence, 1)
}

fun makeSequence2(
    prevNumber: Int,
    limit: Int,
    sequence: IntArray,
    step: Int,
){
    if(step > sequence.size){
        println(sequence.joinToString(separator = " "))
        return
    }
    for(i in 0..<limit){
        if(i+1 <= prevNumber) continue
        sequence[step-1] = i + 1
        makeSequence2(i+1, limit, sequence, step+1)
    }
}