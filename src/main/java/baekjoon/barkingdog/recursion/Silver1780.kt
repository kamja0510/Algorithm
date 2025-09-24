package baekjoon.barkingdog.recursion

fun main(){
    val size = readln().toInt()
    val  array = Array(size){
        readln().split(" ").map{ it.toInt() }.toIntArray()
    }
    val answer = intArrayOf(0,0,0)
    slice(0, 0, size, array, answer)
    answer.forEach {
        println(it)
    }
}

fun slice(
    startRow: Int,
    startColumn: Int,
    size: Int,
    array: Array<IntArray>,
    answer: IntArray,
){
    val number = array[startRow][startColumn]
    if (size == 1){
        when(number){
            -1 -> answer[0] += 1
            0 -> answer[1] += 1
            1 -> answer[2] += 1
        }
        return
    }
    val nextSize = size/3
    for(row in startRow..<startRow + size){
        for(column in startColumn..<startColumn + size){
            if(number != array[row][column]) {
                for(i in 0..<3){
                    for(j in 0..<3){
                        slice(startRow + i * nextSize, startColumn + j * nextSize, nextSize, array, answer)
                    }
                }
                return
            }
        }
    }
    when(number){
        -1 -> answer[0] += 1
        0 -> answer[1] += 1
        1 -> answer[2] += 1
    }
    return
}