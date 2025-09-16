package baekjoon.barkingdog.bfs

fun main() {
    val (numberOfRow, numberOfColumn) = readln().split(" ").map{ it.toInt() }
    val paper = Array(numberOfRow){
        readln().split(" ").map{ it.toInt() }
    }
    val visit = Array(numberOfRow){
        BooleanArray(numberOfColumn)
    }
    val rowDirection = intArrayOf(0, 1, -1, 0)  // 우, 하, 상, 좌
    val columnDirection = intArrayOf(1, 0, 0, -1)
    var numberOfDraw = 0
    var maxExtent = 0
    val queue = ArrayDeque<Pair<Int,Int>>()
    for(row in 0..<numberOfRow){
        for(column in 0..<numberOfColumn){
            if(paper[row][column] == 0 || visit[row][column]) continue
            numberOfDraw++
            queue.addLast(Pair(row, column))
            visit[row][column] = true
            var extent = 0
            while(queue.isNotEmpty()){
                val current = queue.removeFirst()
                extent++
                repeat(4){
                    val nextRow = current.first + rowDirection[it]
                    val nextColumn = current.second + columnDirection[it]
                    if(nextRow !in 0..<numberOfRow || nextColumn !in 0..<numberOfColumn) return@repeat
                    if(paper[nextRow][nextColumn] != 1 || visit[nextRow][nextColumn]) return@repeat
                    queue.addLast(Pair(nextRow, nextColumn))
                    visit[nextRow][nextColumn] = true
                }
            }
            maxExtent = maxOf(extent, maxExtent)
        }
    }
    println(numberOfDraw)
    println(maxExtent)
}
