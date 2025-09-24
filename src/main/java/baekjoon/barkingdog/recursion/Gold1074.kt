package baekjoon.barkingdog.recursion

fun main(){
    val (size, row, column) = readln().split(" ").map{ it.toInt() }
    println(findPosition(1 shl size,row,column,0))
}

fun findPosition(
    size: Int,
    row: Int,
    column: Int,
    count: Int,
): Int{
    if(size == 1) return count
    val half = size /2
    return if (row in 0..<half && column in 0..<half) {
        findPosition(half, row, column, count)
    } else if (row in 0..<half && column in half..<size) {
        findPosition(half, row, column-half, count+ half*half)
    } else if (row in half..<size && column in 0..<half) {
        findPosition(half, row-half, column, count+half*half*2)
    } else {
        findPosition(half, row-half, column-half, count+half*half*3)
    }
}