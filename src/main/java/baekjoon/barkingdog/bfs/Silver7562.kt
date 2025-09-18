package baekjoon.barkingdog.bfs

fun main() {
    val testCases = readln().toInt()
    repeat(testCases)testCase@{
        val size = readln().toInt()
        val (startRow, startColumn) = readln().split(" ").map { it.toInt() }
        val (targetRow, targetColumn) = readln().split(" ").map { it.toInt() }
        var answer = 0
       if(startRow == targetRow && startColumn == targetColumn){
           println(answer)
           return@testCase
       }
        val rowDirection = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
        val columnDirection = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)
        val visit = Array(size){
            BooleanArray(size)
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(startRow, startColumn))
        visit[startRow][startColumn] = true
        while(queue.isNotEmpty()){
            answer++
            repeat(queue.size){
                val current = queue.removeFirst()
                for(i in rowDirection.indices){
                    val nextRow = current.first + rowDirection[i]
                    val nextColumn = current.second + columnDirection[i]
                    if(targetRow == nextRow && targetColumn == nextColumn){
                        println(answer)
                        return@testCase
                    }
                    if(nextRow !in 0..<size || nextColumn !in 0..<size) continue
                    if(visit[nextRow][nextColumn]) continue
                    queue.addLast(Pair(nextRow, nextColumn))
                    visit[nextRow][nextColumn] = true
                }
            }
        }
    }
}