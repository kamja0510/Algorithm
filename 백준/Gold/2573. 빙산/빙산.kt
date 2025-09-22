package baekjoon.barkingdog.bfs

fun main() {
    val (rows, columns) = readln().split(" ").map{ it.toInt() }
    val map = Array(rows){
        readln().split(" ").map{ it.toInt() }.toIntArray()
    }
    val directions = arrayOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    var answer = 0
    while(true){
        val visit = Array(rows){
            BooleanArray(columns)
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        var piece = 0
        for(row in 1..<rows-1){
            for(column in 1..<columns-1){
                if(map[row][column] <= 0 || visit[row][column]) continue
                piece++
                queue.addLast(Pair(row, column))
                visit[row][column] = true
                while(queue.isNotEmpty()){
                    val current = queue.removeFirst()
                    for((rowDirection, columnDirection) in directions){
                        val nextRow = current.first + rowDirection
                        val nextColumn = current.second + columnDirection
                        if(visit[nextRow][nextColumn]) continue
                        if(map[nextRow][nextColumn] <= 0){
                            map[current.first][current.second]--
                        }else{
                            queue.addLast(Pair(nextRow, nextColumn))
                            visit[nextRow][nextColumn] = true
                        }
                    }
                }
            }
        }
        if(piece >=2) {
            println(answer)
            return
        } else if(piece == 0){
            println(0)
            return
        }
        answer++
    }
}