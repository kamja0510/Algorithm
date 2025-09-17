package baekjoon.barkingdog.bfs

fun main() {
    val rowDirection = intArrayOf(-1, 0, 0, 1)
    val columnDirection = intArrayOf(0, -1, 1, 0)
    val numberOfCase = readln().toInt()
    val result = buildString{
        repeat(numberOfCase){
            val (numberOfColumn, numberOfRow, numberOfCabbage) = readln().split(" ").map{ it.toInt() }
            val field = Array(numberOfRow){
                IntArray(numberOfColumn)
            }
            val visit = Array(numberOfRow){
                BooleanArray(numberOfColumn)
            }
            repeat(numberOfCabbage){
                val (column, row) = readln().split(" ").map{ it.toInt() }
                field[row][column] = 1
            }
            var answer = 0
            val queue = ArrayDeque<Pair<Int,Int>>()
            for(row in 0..<numberOfRow){
                for(column in 0..<numberOfColumn){
                    if(field[row][column] == 1 && !visit[row][column]){
                        answer++
                        queue.addLast(Pair(row,column))
                        visit[row][column] = true
                        while(queue.isNotEmpty()){
                            val current = queue.removeFirst()
                            for(i in 0..3){
                                val nextRow = current.first + rowDirection[i]
                                val nextColumn = current.second + columnDirection[i]
                                if(nextRow !in 0..<numberOfRow || nextColumn !in 0..<numberOfColumn) continue
                                if(field[nextRow][nextColumn] == 0 || visit[nextRow][nextColumn]) continue
                                queue.addLast(Pair(nextRow,nextColumn))
                                visit[nextRow][nextColumn] = true
                            }
                        }
                    }
                }
            }
            appendLine(answer)
        }
    }
    print(result)
}