package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt()}.sorted()
    val sequence = IntArray(length)
    val sb = StringBuilder()
    makePermutation11(0, numbers, sequence, sb)
    print(sb.toString())
}

fun makePermutation11(
    step: Int,
    numbers: List<Int>,
    permutation: IntArray,
    sb: StringBuilder
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{sb.appendLine(it)}
        return
    }

    var prevNumber = -1
    for(i in numbers.indices){
        if(prevNumber == numbers[i]) continue
        prevNumber = numbers[i]
        permutation[step] = numbers[i]
        makePermutation11(step + 1, numbers, permutation, sb)
    }
}