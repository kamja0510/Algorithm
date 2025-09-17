package baekjoon.barkingdog.bfs

fun main(){
    val (numberOfColumn, numberOfRow) = readln().split(" ").map{ it.toInt() }
    val box = Array(numberOfRow){
        readln().split(" ").map{ it.toInt() }.toIntArray()
    }
    val rowDirection = intArrayOf(-1, 0, 0, 1)
    val columnDirection = intArrayOf(0, -1, 1, 0)
    val queue = ArrayDeque<Pair<Int,Int>>()
    for(row in 0..<numberOfRow){
        for(column in 0..<numberOfColumn){
            if(box[row][column]==1){
                queue.addLast(Pair(row,column))
            }
        }
    }
    var ripeningTime = 1

    while(queue.isNotEmpty()){
        val current = queue.removeFirst()
        for(i in 0..3){
            val nextRow = current.first + rowDirection[i]
            val nextColumn = current.second + columnDirection[i]
            if(nextRow !in 0..<numberOfRow || nextColumn !in 0..<numberOfColumn) continue
            if(box[nextRow][nextColumn] != 0) continue
            queue.addLast(Pair(nextRow, nextColumn))
            ripeningTime = box[current.first][current.second] + 1
            box[nextRow][nextColumn] = ripeningTime
        }
    }
    if(box.any{ row -> row.any { it == 0}}){
        println(-1)
    }else{
        println(ripeningTime-1)
    }
}