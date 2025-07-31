fun main() {
    val threeNumbers = readln().split(" ").map { it.toInt() }
    val sortedThreeNumbers = threeNumbers.sorted()
    val result = buildString {
        append("${sortedThreeNumbers[0]} ")
        append("${sortedThreeNumbers[1]} ")
        append("${sortedThreeNumbers[2]}")
    }
    println(result)
}