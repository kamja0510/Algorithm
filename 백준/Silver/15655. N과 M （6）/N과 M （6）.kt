package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{it.toInt()}
    val numbers = readln().split(" ").map{ it.toInt()}.sorted()
    val sequence = IntArray(length)
    val sb = StringBuilder()
    makeSequence6(0, 0, numbers, sequence, sb)
    print(sb.toString())
}

fun makeSequence6(
    step: Int,
    startIndex: Int,
    numbers: List<Int>,
    sequence: IntArray,
    sb : StringBuilder
){
    if(step == sequence.size){
        sequence.joinToString(" ").also{ sb.appendLine(it) }
        return
    }
    if(startIndex >= numbers.size) return
    for(i in startIndex until numbers.size){
        if(step + numbers.size  - i < sequence.size) break
        sequence[step] = numbers[i]
        makeSequence6(step+1, i+1, numbers, sequence, sb)
    }
}