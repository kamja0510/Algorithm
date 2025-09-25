package baekjoon.barkingdog.backtracking

fun main(){
    val (limit, size) = readln().split(" ").map{ it.toInt() }
    val sequence = IntArray(size)
    val sb = StringBuilder()
    makeSequence3(limit, sequence, 1, sb).toString()
    print(sb.toString())
}

fun makeSequence3(
    limit: Int,
    sequence: IntArray,
    step: Int,
    sb: StringBuilder
){
    if(step > sequence.size){
        sequence.forEach {
            sb.append(it)
            sb. append(" ")
        }
        sb.appendLine()
        return
    }
    for(i in 0..<limit){
        sequence[step-1] = i + 1
        makeSequence3(limit, sequence, step+1,sb)
    }
}