package baekjoon.barkingdog.backtracking

fun main(){
    val (limit, size) = readln().split(" ").map{ it.toInt() }
    val isUsed = BooleanArray(limit)
    val sequence = IntArray(size)
    makeSequence(isUsed, sequence, 1)
}

fun makeSequence(
    isUsed: BooleanArray,
    sequence: IntArray,
    step: Int,
){
    if(step > sequence.size){
        println(sequence.joinToString(separator = " "))
        return
    }
    for(i in 0..<isUsed.size){
        if(!isUsed[i]){
            isUsed[i] = true
            sequence[step-1] = i + 1
            makeSequence(isUsed, sequence, step+1)
            isUsed[i] = false
        }
    }
}