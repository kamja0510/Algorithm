package baekjoon.barkingdog.bfs

fun main(){
    val directions = arrayOf(
        Triple(0,0,1),
        Triple(0,0,-1),
        Triple(0,1,0),
        Triple(0,-1,0),
        Triple(1,0,0),
        Triple(-1,0,0),
    )
     testCase@ while(true){
        val (height, rows, columns) = readln().split(" ").map{ it.toInt() }
        if(height == 0 && rows == 0 && columns == 0) break

        var start : Triple<Int, Int, Int> = Triple(0,0,0)
        val building = Array(height){
            Array(rows){
                ""
            }
        }
         repeat(height * (rows + 1)){ index ->
             val zIndex = index / (rows + 1)
             val rowIndex = index % (rows + 1)
             if(rowIndex != rows) building[zIndex][rowIndex] = readln() else readln()
         }
        val visit = Array(height){
            Array(rows){
                BooleanArray(columns)
            }
        }
        building.forEachIndexed{ zIndex, grid ->
            grid.forEachIndexed{ rowIndex, row ->
                row.forEachIndexed{ columnIndex, obj ->
                    if(obj == 'S') start = Triple(zIndex, rowIndex, columnIndex)
                }
            }
        }
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        var answer = 0
        queue.addLast(start)
        visit[start.first][start.second][start.third] = true
        while(queue.isNotEmpty()){
            answer++
            for(i in 0..<queue.size){
                val current = queue.removeFirst()
                for((zDirection, rowDirection, columnDirection) in directions){
                    val nextZ = current.first + zDirection
                    val nextRow = current.second + rowDirection
                    val nextColumn = current.third + columnDirection
                    if(nextZ !in 0..<height || nextRow !in 0..<rows || nextColumn !in 0..<columns) continue
                    if(building[nextZ][nextRow][nextColumn] == '#' || visit[nextZ][nextRow][nextColumn]) continue
                    if(building[nextZ][nextRow][nextColumn] == 'E'){
                        println("Escaped in $answer minute(s).")
                        continue@testCase
                    }
                    queue.addLast(Triple(nextZ, nextRow, nextColumn))
                    visit[nextZ][nextRow][nextColumn] = true
                }
            }
        }
        println("Trapped!")
    }
}