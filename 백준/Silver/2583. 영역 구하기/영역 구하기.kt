package baekjoon.barkingdog.bfs

fun main() {
    val (rows, columns, squares) = readln().split(" ").map{ it.toInt() }
    val directions = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    val grid = Array(rows){
        IntArray(columns)
    }
    val visit = Array(rows){
        BooleanArray(columns)
    }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val extents = mutableListOf<Int>()
    repeat(squares){
        val (bottomStartX, bottomStartY, topEndX, topEndY) = readln().split(" ").map{ it.toInt() }
        for(rowIndex in bottomStartY..<topEndY){
            for(columnIndex in bottomStartX..<topEndX){
                grid[rows-1-rowIndex][columnIndex] = 1
            }
        }
    }
    var area = 0
    for(rowIndex in 0..<rows){
        for(columnIndex in 0..<columns){
            if(grid[rowIndex][columnIndex] == 1 || visit[rowIndex][columnIndex]) continue
            queue.addLast(Pair(rowIndex, columnIndex))
            visit[rowIndex][columnIndex] = true
            area++
            var extent = 0
            while(queue.isNotEmpty()){
                val current = queue.removeFirst()
                extent++
                for((rowDirection, columnDirection) in directions){
                    val nextRow = current.first + rowDirection
                    val nextColumn = current.second + columnDirection
                    if(nextRow !in 0..<rows || nextColumn !in 0..<columns) continue
                    if(grid[nextRow][nextColumn] == 1 || visit[nextRow][nextColumn]) continue
                    queue.addLast(Pair(nextRow, nextColumn))
                    visit[nextRow][nextColumn] = true
                }
            }
            extents.add(extent)
        }
    }
    println(area)
    println(extents.sorted().joinToString(separator = " "))
}