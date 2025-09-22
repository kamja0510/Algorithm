import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val directions = arrayOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val map = Array(size) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visit = Array(size) { BooleanArray(size) }
    val queue = ArrayDeque<Pair<Int, Int>>()

    var islandId = 2
    for (row in 0 until size) {
        for (column in 0 until size) {
            if (map[row][column] == 1 && !visit[row][column]) {
                queue.addLast(Pair(row, column))
                visit[row][column] = true
                map[row][column] = islandId

                while (queue.isNotEmpty()) {
                    val current = queue.removeFirst()

                    for ((rowDirection, columnDirection) in directions) {
                        val nextRow = current.first + rowDirection
                        val nextColumn = current.second + columnDirection

                        if (nextRow in 0..<size && nextColumn in 0..<size &&
                            map[nextRow][nextColumn] == 1 && !visit[nextRow][nextColumn]) {
                            visit[nextRow][nextColumn] = true
                            map[nextRow][nextColumn] = islandId
                            queue.add(Pair(nextRow, nextColumn))
                        }
                    }
                }
                islandId++
            }
        }
    }

    val distance = Array(size) { IntArray(size) { -1 } }

    for (row in 0..<size) {
        for (column in 0..<size) {
            if (map[row][column] != 0) {
                queue.add(Pair(row, column))
                distance[row][column] = 0
            }
        }
    }

    var answer = Integer.MAX_VALUE
    var hasAnswer = false
    while (queue.isNotEmpty()) {
        repeat(queue.size){
            val current = queue.removeFirst()
            val currentIslandId = map[current.first][current.second]
            val currentDist = distance[current.first][current.second]

            for ((rowDirection, columnDirection) in directions){
                val nextRow = current.first + rowDirection
                val nextColumn = current.second + columnDirection

                if (nextRow !in 0..<size || nextColumn !in 0..<size) continue

                if (map[nextRow][nextColumn] != 0 && map[nextRow][nextColumn] != currentIslandId) {
                    val bridgeLength = currentDist + distance[nextRow][nextColumn]
                    answer = minOf(bridgeLength, answer)
                    hasAnswer = true
                }

                if (distance[nextRow][nextColumn] == -1) {
                    distance[nextRow][nextColumn] = currentDist + 1
                    map[nextRow][nextColumn] = currentIslandId
                    queue.add(Pair(nextRow, nextColumn))
                }
            }
        }
        if(hasAnswer) {
            println(answer)
            return
        } 
    }
}

