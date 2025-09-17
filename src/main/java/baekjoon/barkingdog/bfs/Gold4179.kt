package baekjoon.barkingdog.bfs

fun main(){
    val (numberOfRow, numberOfColumn) = readln().split(" ").map{ it.toInt() }
    val maze = Array(numberOfRow){
        readln().toCharArray()
    }
    val rowDirection = intArrayOf(-1, 0, 0, 1)
    val columnDirection = intArrayOf(0, -1, 1, 0)

    var answer = 0
    var isEscapable = false

    val queue = ArrayDeque<Node>()
    maze.forEachIndexed{ rowIndex, string ->
        string.forEachIndexed { columnIndex, char ->
            if(char == 'J') {
                if(rowIndex == 0 || rowIndex == numberOfRow -1 || columnIndex == 0 || columnIndex == numberOfColumn - 1){
                    println(1)
                    return
                }
                queue.addLast(Node(rowIndex, columnIndex, 1))
            }
            if(char == 'F') queue.addFirst(Node(rowIndex, columnIndex, 1))
        }
    }
    loop@ while(queue.isNotEmpty()){
        val current = queue.removeFirst()
        val currentObject = maze[current.row][current.column]
        for(i in rowDirection.indices){
            val nextRow = current.row + rowDirection[i]
            val nextColumn = current.column + columnDirection[i]
            if(nextRow !in 0..<numberOfRow || nextColumn !in 0..<numberOfColumn) continue
            if(maze[nextRow][nextColumn] != '.') continue
            if(currentObject == 'J' &&
                (nextRow == 0 || nextRow == numberOfRow -1 || nextColumn == 0 || nextColumn == numberOfColumn - 1)
                ){
                isEscapable = true
                answer = current.escapeTime + 1
                break@loop
            }
            queue.addLast(Node(nextRow,nextColumn, current.escapeTime + 1))
            maze[nextRow][nextColumn] = currentObject
        }
    }
    println(
        if(isEscapable) answer else "IMPOSSIBLE"
    )
}

data class Node(
    val row: Int,
    val column: Int,
    val escapeTime: Int
)