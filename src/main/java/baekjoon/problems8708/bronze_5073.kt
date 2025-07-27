package baekjoon.problems8708

fun main() {
    while(true){
        val line = readlnOrNull() ?: break
        if(line == "0 0 0") break
        val lineLengths = line.split(" ").map{ it.toInt() }
        val max = lineLengths.max()
        val sum = lineLengths.sum()
        val lineLengthsSet = lineLengths.toSet()
        if(sum <= 2*max) println("Invalid")
        else if(lineLengthsSet.size == 3) println("Scalene")
        else if(lineLengthsSet.size == 2) println("Isosceles")
        else if(lineLengthsSet.size == 1) println("Equilateral")
    }
}