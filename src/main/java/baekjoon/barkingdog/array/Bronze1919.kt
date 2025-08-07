package baekjoon.barkingdog.array

import kotlin.math.abs

fun main() {
    val firstWord = readln()
    val secondWord = readln()

    val charCountArray = ShortArray(26)
    firstWord.forEach { charCountArray[it - 'a']++ }
    secondWord.forEach { charCountArray[it - 'a']-- }
    val result = charCountArray.sumOf {  abs(it.toInt()) }
    print(result)
}