package baekjoon.barkingdog.basicCode

fun main() {
    val threeNumbers = readln().split(" ").map { it.toInt() }
    val sortedThreeNumbers = threeNumbers.sorted()
    sortedThreeNumbers.forEach{
        print("$it ")
    }
}