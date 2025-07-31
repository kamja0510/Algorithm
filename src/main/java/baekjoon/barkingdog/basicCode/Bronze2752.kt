package baekjoon.barkingdog.basicCode

fun main() {
    val threeNumbers = readln().split(" ").map { it.toInt() }.toIntArray().sorted().joinToString(separator = " ")
    println(threeNumbers)
}