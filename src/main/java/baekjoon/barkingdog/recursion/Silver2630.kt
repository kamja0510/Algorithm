package baekjoon.barkingdog.recursion

fun main(){
    val size = readln().toInt()
    val paper = Array(size){
        readln().split(" ").map{ it.toInt() }
    }
    val answer = intArrayOf(0,0)
    dividePaper(0, 0, size, paper, answer)
    answer.forEach {
        println(it)
    }
}

fun dividePaper(
    startRow: Int,
    startColumn: Int,
    size: Int,
    paper: Array<List<Int>>,
    answer: IntArray
){
    val color =  paper[startRow][startColumn]
    if(size == 1) {
        when(color){
            0 -> answer[0] += 1
            1 -> answer[1] += 1
        }
        return
    }
    val nextSize = size / 2
    for(row in startRow..<startRow + size){
        for(column in startColumn..<startColumn + size){
            if(color != paper[row][column]){
                for(i in 0..<2){
                    for(j in 0..<2){
                        dividePaper(startRow + nextSize * i, startColumn + nextSize * j, nextSize, paper, answer)
                    }
                }
                return
            }
        }
    }
    when(color){
        0 -> answer[0] += 1
        1 -> answer[1] += 1
    }
    return
}