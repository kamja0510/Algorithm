package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt() }.sorted()
    val permutation = IntArray(length)
    val visit = BooleanArray(n)
    val sb = StringBuilder()
    makePermutation9(0, numbers, permutation, visit, sb)
    print(sb.toString())
}

fun makePermutation9(
    step: Int,
    numbers: List<Int>,
    permutation: IntArray,
    visit: BooleanArray,
    sb : StringBuilder,
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{ sb.appendLine(it)}
        return
    }

    for( i in numbers.indices){
        if(visit[i]) continue
        if(i != 0 && numbers[i-1] == numbers[i] && !visit[i-1]) continue
        visit[i] = true
        permutation[step] = numbers[i]
        makePermutation9(step+1, numbers, permutation, visit, sb)
        visit[i] = false
    }
}