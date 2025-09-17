package baekjoon.barkingdog.bfs

fun main(){
    val rowDirection = intArrayOf(-1, 0, 0, 1)
    val columnDirection = intArrayOf(0, -1, 1, 0)
    val queue = ArrayDeque<Pair<Int,Int>>()
    val size = readln().toInt()
    val rgb = Array(size){
        readln()
    }
    var visit = Array(size){
        BooleanArray(size)
    }
    var blindness = 0
    var notBlindness = 0
    for(row in 0..<size){
        for(column in 0..<size){
            if(visit[row][column]) continue
            queue.addLast(Pair(row,column))
            visit[row][column] = true
            val currentColor  = rgb[row][column]
            notBlindness++
            while(queue.isNotEmpty()){
                val current = queue.removeFirst()
                for(i in rowDirection.indices){
                    val nextRow = current.first + rowDirection[i]
                    val nextColumn = current.second + columnDirection[i]
                    if(nextRow !in 0..<size || nextColumn !in 0..<size) continue
                    if(rgb[nextRow][nextColumn] != currentColor || visit[nextRow][nextColumn]) continue
                    queue.addLast(Pair(nextRow, nextColumn))
                    visit[nextRow][nextColumn] = true
                }
            }
        }
    }
    visit.forEach{ row ->
        row.fill(false)
    }

    for(row in 0..<size){
        for(column in 0..<size){
            if(visit[row][column]) continue
            queue.addLast(Pair(row,column))
            visit[row][column] = true
            val currentColor  = rgb[row][column]
            blindness++
            while(queue.isNotEmpty()){
                val current = queue.removeFirst()
                for(i in rowDirection.indices){
                    val nextRow = current.first + rowDirection[i]
                    val nextColumn = current.second + columnDirection[i]
                    if(nextRow !in 0..<size || nextColumn !in 0..<size) continue
                    if(currentColor == 'B'){
                        if(rgb[nextRow][nextColumn] != currentColor || visit[nextRow][nextColumn]) continue
                    }else{
                        if(rgb[nextRow][nextColumn] == 'B' || visit[nextRow][nextColumn]) continue
                    }
                    queue.addLast(Pair(nextRow, nextColumn))
                    visit[nextRow][nextColumn] = true
                }
            }
        }
    }
    println("$notBlindness $blindness")
}