package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt() }.sorted()
    val permutation = IntArray(length)
    val sb = StringBuilder()
    makePermutation8(
        step = 0,
        prevIndex = 0,
        numbers = numbers,
        permutation = permutation,
        sb = sb
    )
    print(sb.toString())
}

fun makePermutation8(
    step: Int,
    prevIndex: Int,
    numbers: List<Int>,
    permutation: IntArray,
    sb : StringBuilder
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{ sb.appendLine(it)}
        return
    }
    
    for(i in prevIndex..<numbers.size){
        permutation[step] = numbers[i]
        makePermutation8(step+1, i, numbers, permutation, sb)
    }
}