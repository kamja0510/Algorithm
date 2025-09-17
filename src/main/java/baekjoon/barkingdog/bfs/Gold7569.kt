package baekjoon.barkingdog.bfs

fun main() {
    val rowDirection = intArrayOf(-1, 0, 0, 0, 0, 1)
    val columnDirection = intArrayOf(0, -1, 1, 0, 0, 0)
    val zDirection = intArrayOf(0, 0, 0, -1, 1, 0)
    val queue = ArrayDeque<Triple<Int, Int, Int>>()

    val (columns, rows, height) = readln().split(" ").map{ it.toInt() }
    val farm = Array(height){
        Array(rows){
            readln().split(" ").map{ it.toInt() }.toIntArray()
        }
    }
    farm.forEachIndexed{ zIndex,  grid->
        grid.forEachIndexed{ rowIndex, row ->
            row.forEachIndexed{ columnIndex, tomato ->
                if(tomato == 1) queue.addLast(Triple(zIndex, rowIndex, columnIndex))
            }
        }
    }

    while(queue.isNotEmpty()){
        val current = queue.removeFirst()
        for(i in rowDirection.indices){
            val nextZ = current.first + zDirection[i]
            val nextRow = current.second + rowDirection[i]
            val nextColumn = current.third + columnDirection[i]
            if(nextZ !in 0..<height || nextRow !in 0..<rows || nextColumn !in 0..<columns) continue
            if(farm[nextZ][nextRow][nextColumn] != 0) continue
            queue.addLast(Triple(nextZ, nextRow, nextColumn))
            farm[nextZ][nextRow][nextColumn] = farm[current.first][current.second][current.third] + 1
        }
    }
    var answer = 0
    farm.forEach{ grid ->
        grid.forEach{ row ->
            row.forEach{ tomato ->
                if(tomato==0){
                    println(-1)
                    return
                }
                if(tomato > answer) answer = tomato
            }
        }
    }
    println(answer-1)

}