package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt()}.distinct().sorted()
    val permutation = IntArray(length)
    val sb = StringBuilder()
    makePermutation12(0, 0,numbers, permutation, sb)
    print(sb.toString())
}

fun makePermutation12(
    step: Int,
    prevIndex: Int,
    numbers: List<Int>,
    permutation: IntArray,
    sb: StringBuilder
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{ sb.appendLine(it)}
        return
    }

    for(i in prevIndex..<numbers.size){
        permutation[step] = numbers[i]
        makePermutation12(step + 1, i, numbers, permutation, sb)
    }
}