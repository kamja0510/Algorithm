package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt() }.sorted()
    val permutation = IntArray(length)
    val sb = StringBuilder()
    makePermutation7(0, numbers, permutation, sb)
    print(sb.toString())
}

fun makePermutation7(
    step: Int,
    numbers: List<Int>,
    permutation: IntArray,
    sb: StringBuilder
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{ sb.appendLine(it) }
        return
    }

    for(i in numbers){
        permutation[step] = i
        makePermutation7(step + 1, numbers, permutation, sb)
    }
}