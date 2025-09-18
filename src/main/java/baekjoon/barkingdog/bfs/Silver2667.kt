package baekjoon.barkingdog.bfs

fun main() {
    val directions = arrayOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1
    )
    val size = readln().toInt()
    val map = Array(size){
        readln().toCharArray()
    }
    val visit = Array(size){
        BooleanArray(size)
    }
    val extents = mutableListOf<Int>()
    var area = 0
    val queue = ArrayDeque<Pair<Int, Int>>()
    for(rowIndex in 0..<size){
        for(columnIndex in 0..<size){
            if(map[rowIndex][columnIndex] == '0' || visit[rowIndex][columnIndex]) continue
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
                    if(nextRow !in 0..<size || nextColumn !in 0..<size) continue
                    if(map[nextRow][nextColumn] == '0' || visit[nextRow][nextColumn]) continue
                    queue.addLast(nextRow to nextColumn)
                    visit[nextRow][nextColumn] = true
                }
            }
            extents.add(extent)
        }
    }
    val result = buildString{
        appendLine(area)
        appendLine(
            extents.sorted().joinToString(separator = "\n")
        )
    }
    print(result)
}
