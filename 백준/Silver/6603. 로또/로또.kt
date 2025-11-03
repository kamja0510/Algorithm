package baekjoon.barkingdog.backtracking

fun main(){
    while(true){
        val input = readln().split(" ").map{ it.toInt() }
        val k = input[0]
        if(k == 0) break

        val sb = StringBuilder()
        val numbers = input.drop(1)
        val combination = IntArray(6)
        selectCombination(0, -1, numbers, combination, sb)
        println(sb.toString())
    }
}

fun selectCombination(
    depth: Int,
    prevIndex: Int,
    numbers: List<Int>,
    combination: IntArray,
    sb: StringBuilder
){
    if(depth == combination.size){
        sb.appendLine(combination.joinToString(" "))
        return
    }

    for(i in prevIndex + 1..<numbers.size){
        if(6-depth > numbers.size - i) continue
        combination[depth] = numbers[i]
        selectCombination(depth + 1, i, numbers, combination, sb)
    }
}