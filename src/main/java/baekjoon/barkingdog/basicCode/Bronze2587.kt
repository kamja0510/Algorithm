package baekjoon.barkingdog.basicCode

fun main() {
    val numbers = List(5){ readln().toInt() }.sorted()
    println(numbers.sum()/5)
    println(numbers[2])
}
// 18592KB 116MS