package baekjoon.barkingdog.array

fun main() {
    val word = readln()
    val array = IntArray(26)
    word.forEach{
        array[(it.code-'a'.code)]++
    }
    
    val result = buildString { 
        array.forEach { append("$it ") }
    }
    
    println(result)
}