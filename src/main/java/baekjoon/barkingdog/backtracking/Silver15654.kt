package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt()}.sorted()
    val sequence = IntArray(length)
    val sb = StringBuilder()
    val visited = BooleanArray(n)
    makeSequence5(0, numbers, sequence, sb, visited)
    print(sb.toString())
}

fun makeSequence5(
    step: Int,
    numbers: List<Int>,
    sequence: IntArray,
    sb : StringBuilder,
    visited: BooleanArray
){
    if(step == sequence.size){
        sequence.joinToString(" ").also{ sb.appendLine(it) }
        return
    }
    repeat(numbers.size){i ->
        if(visited[i]) return@repeat
        visited[i] = true
        sequence[step] = numbers[i]
        makeSequence5(step+1, numbers, sequence, sb, visited)
        visited[i] = false
    }
}