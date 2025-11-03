package baekjoon.barkingdog.backtracking

fun main(){
    val (n, length) = readln().split(" ").map{ it.toInt() }
    val numbers = readln().split(" ").map{ it.toInt()}.sorted()
    val permutation = IntArray(length)
    val sb = StringBuilder()
    val visited = BooleanArray(n)
    makePermutation10(0, -1, numbers, permutation, visited, sb)
    print(sb.toString())
}

fun makePermutation10(
    step: Int,
    prevIndex: Int,
    numbers: List<Int>,
    permutation: IntArray,
    visited: BooleanArray,
    sb: StringBuilder
){
    if(step == permutation.size){
        permutation.joinToString(" ").also{ sb.appendLine(it) }
        return
    }

    for(i in prevIndex+1..<numbers.size){
        if(i != 0 && numbers[i] == numbers[i-1] && !visited[i-1]) continue
        visited[i] = true
        permutation[step] = numbers[i]
        makePermutation10(step+1, i, numbers, permutation, visited, sb)
        visited[i] = false
    }
}