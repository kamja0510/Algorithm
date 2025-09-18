package baekjoon.barkingdog.bfs

fun main(){
    val testCases = readln().toInt()
    val directions = arrayOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    repeat(testCases)testCase@{
        val (columns, rows) = readln().split(" ").map{ it.toInt() }
        val map = Array(rows){
            readln().toCharArray()
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        var answer = 0
        map.forEachIndexed{ rowIndex, row ->
            row.forEachIndexed { columnIndex, item ->
                if(item == '*') queue.addLast(Pair(rowIndex, columnIndex))
                if(item == '@'){
                    if(rowIndex == 0 || columnIndex == 0 || rowIndex == rows -1 || columnIndex == columns- 1){
                        println(1)
                        return@testCase
                    }
                    queue.addFirst(Pair(rowIndex, columnIndex))
                }
            }
        }
        while(queue.isNotEmpty()){
            answer++
            repeat(queue.size){
                val current = queue.removeFirst()
                val currentObject = map[current.first][current.second]
                if(currentObject == '@' && (current.first == 0 || current.second == 0 || current.first == rows-1 || current.second == columns - 1)){
                    println(answer)
                    return@testCase
                }
                for((rowDirection, columnDirection) in directions){
                    val nextRow = current.first + rowDirection
                    val nextColumn = current.second + columnDirection
                    if(nextRow !in 0..<rows || nextColumn !in 0..<columns) continue
                    if(currentObject == '@'){
                        if(map[nextRow][nextColumn] != '.') continue
                    }else{
                        if(map[nextRow][nextColumn] == '*' || map[nextRow][nextColumn] == '#') continue
                    }
                    queue.addLast(Pair(nextRow, nextColumn))
                    map[nextRow][nextColumn] = currentObject
                }
            }
        }
        println("IMPOSSIBLE")
    }
}