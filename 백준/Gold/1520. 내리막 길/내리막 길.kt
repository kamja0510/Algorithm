package baekjoon

fun main(){
    val (rowCount, columnCount) = readln().split(" ").map{ it.toInt() }
    val map = List<List<Int>>(rowCount){ readln().split(" ").map{ it.toInt() } }
    val dp = Array<IntArray>(rowCount){IntArray(columnCount){ -1 } }
    val dRow = listOf(0,0,1,-1)
    val dColumn = listOf(1,-1,0,0)

    fun dfs(row: Int, column: Int): Int{
        if(row == rowCount-1 && column == columnCount-1) return 1
        if(dp[row][column] != -1) return dp[row][column]
        dp[row][column] = 0

        for(i in 0..3){
            val nextRow = row + dRow[i]
            val nextColumn = column + dColumn[i]
            if(nextRow !in 0 until rowCount || nextColumn !in 0 until columnCount) continue
            if(map[row][column] > map[nextRow][nextColumn]) dp[row][column] += dfs(nextRow, nextColumn)
        }

        return dp[row][column]
    }

    println(dfs(0,0))
}