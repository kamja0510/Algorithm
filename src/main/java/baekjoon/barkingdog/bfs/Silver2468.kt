package baekjoon.barkingdog.bfs

fun main() {
    val directions = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    val size = readln().toInt()
    val map = Array(size){
        readln().split(" ").map{ it.toInt() }
    }
    var maxHeight = 1
    var minHeight = 100
    val rainHeights = mutableSetOf<Int>()
    map.forEach{ row ->
        row.forEach{ height ->
            maxHeight = maxOf(height, maxHeight)
            minHeight = minOf(height, minHeight)
            rainHeights.add(height)
        }
    }
    var maxArea = 1
    val queue = ArrayDeque<Pair<Int, Int>>()

    for(rainHeight in rainHeights){
        val visit = Array(size){
            BooleanArray(size)
        }
        var area = 0
        for(rowIndex in 0..<size){
            for(columnIndex in 0..<size){
                if(map[rowIndex][columnIndex] <= rainHeight || visit[rowIndex][columnIndex]) continue
                queue.addLast(Pair(rowIndex, columnIndex))
                visit[rowIndex][columnIndex] = true
                area++
                while(queue.isNotEmpty()){
                    val current = queue.removeFirst()
                    for((rowDirection, columnDirection) in directions){
                        val nextRow = current.first + rowDirection
                        val nextColumn = current.second + columnDirection
                        if(nextRow !in 0..<size || nextColumn !in 0..<size) continue
                        if(map[nextRow][nextColumn] <= rainHeight || visit[nextRow][nextColumn]) continue
                        queue.addLast(Pair(nextRow, nextColumn))
                        visit[nextRow][nextColumn] = true
                    }
                }
            }
        }
        maxArea = maxOf(area, maxArea)
    }
    println(maxArea)
}