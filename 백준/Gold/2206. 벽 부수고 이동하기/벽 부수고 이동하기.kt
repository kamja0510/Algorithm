package baekjoon.barkingdog.bfs

fun main(){
    data class Position(
        val row: Int,
        val column: Int,
        val broken: Int, // 0: 아직 안부숨, 1: 이미 한 번 부숨
    )

    val directions = arrayOf(
        0 to 1,
        0 to -1,
        -1 to 0,
        1 to 0,
    )
    val (rows, columns) = readln().split(" ").map{ it.toInt() }
    val map = Array(rows){
        readln()
    }
    val visit = Array(rows){
        Array(columns){ IntArray(2) { 0 } }
    }

    val queue = ArrayDeque<Position>()

    queue.addLast(Position(0, 0, 0))
    visit[0][0][0] = 1
    while(queue.isNotEmpty()){
        repeat(queue.size){
            val current = queue.removeFirst()
            val distance = visit[current.row][current.column][current.broken]
            if(current.row == rows -1 && current.column == columns -1){
                println(distance)
                return
            }
            for((rowDirection, columnDirection) in directions){
                val nextRow = current.row + rowDirection
                val nextColumn = current.column + columnDirection
                if(nextRow !in 0..<rows || nextColumn !in 0..<columns) continue
                if(map[nextRow][nextColumn] == '0'){
                    if(visit[nextRow][nextColumn][current.broken] == 0){
                        visit[nextRow][nextColumn][current.broken] = distance + 1
                        queue.addLast(Position(nextRow, nextColumn, current.broken))
                    }
                }else{
                    if(current.broken == 0 && visit[nextRow][nextColumn][1] == 0){
                        visit[nextRow][nextColumn][1] = distance + 1
                        queue.addLast(Position(nextRow, nextColumn, 1))
                    }
                }
            }
        }
    }
    println(-1)
}