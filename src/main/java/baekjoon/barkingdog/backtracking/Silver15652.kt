package baekjoon.barkingdog.backtracking

fun main(){
    val (limit, size) = readln().split(" ").map{ it.toInt() }
    val sequence = IntArray(size)
    val sb = StringBuilder()
    makeSequence4(0, limit, sequence, 1, sb)
    print(sb.toString())
}

fun makeSequence4(
    prevNumber: Int,
    limit: Int,
    sequence: IntArray,
    step: Int,
    sb: StringBuilder,
){
    if(step > sequence.size){
        sequence.forEachIndexed{ index, number ->
            sb.append(number)
            if(index == sequence.size-1){
                sb.appendLine()
            }else sb.append(" ")
        }
        return
    }
    for(i in prevNumber..<limit){
        sequence[step-1] = i + 1
        makeSequence4(i, limit, sequence, step+1, sb)
    }
}