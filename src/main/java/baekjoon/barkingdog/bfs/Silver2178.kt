package baekjoon.barkingdog.bfs

fun main(){
    val (numberOfRow, numberOfColumn) = readln().split(" ").map{ it.toInt() }
    val maze = Array(numberOfRow){
        val input = readln()
        IntArray(numberOfColumn){
            input[it] -'0'
        }
    }
    val visit = Array(numberOfRow){
        BooleanArray(numberOfColumn)
    }
    val rowDirection = intArrayOf(-1,0,0,1)
    val columnDirection = intArrayOf(0,-1,1,0)
    val queue = ArrayDeque<Pair<Int,Int>>()
    queue.addLast(Pair(0,0))
    visit[0][0] = true
    while(queue.isNotEmpty()){
        val current = queue.removeFirst()

         repeat(4){
            val nextRow = current.first + rowDirection[it]
            val nextColumn = current.second + columnDirection[it]
            if(nextRow !in 0..<numberOfRow || nextColumn !in 0..<numberOfColumn) return@repeat
            if(maze[nextRow][nextColumn] == 0 || visit[nextRow][nextColumn]) return@repeat
             queue.addLast(Pair(nextRow, nextColumn))
             visit[nextRow][nextColumn] = true
             maze[nextRow][nextColumn] = maze[current.first][current.second] + 1
         }
    }

    println(maze[numberOfRow-1][numberOfColumn-1])
}