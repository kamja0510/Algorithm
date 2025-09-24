package baekjoon.barkingdog.recursion

fun main(){
    val size = readln().toInt()
    val draw = Array(size){
        CharArray(size){' '}
    }
    drawStar(0, 0, size, draw)
    val result = buildString{
        draw.forEach{
            it.forEach{
                append(it)
            }
            appendLine()
        }
    }
    print(result)
}

fun drawStar(
    startRow: Int,
    startColumn: Int,
    size : Int,
    draw: Array<CharArray>,
){
    if(size == 1){
        draw[startRow][startColumn] = '*'
        return
    }
    val nextSize = size / 3
    for(i in 0..<3){
        for(j in 0..<3){
            if(i == 1 && j == 1) continue
            drawStar(startRow + i * nextSize, startColumn + j * nextSize, nextSize, draw)
        }
    }
    return
}