package baekjoon.barkingdog.recursion

fun main(){
    val rows = readln().toInt()
    val columns = rows * 2 - 1
    val draw = Array(rows){
        CharArray(columns){ ' ' }
    }
    drawTriangle(0, rows-1, rows, draw)
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

fun drawTriangle(
    topRow: Int,
    topColumn: Int,
    height: Int,
    draw: Array<CharArray>
){
    if(height == 3){
        draw[topRow][topColumn] = '*'
        draw[topRow+1][topColumn-1] = '*'
        draw[topRow+1][topColumn+1] = '*'
        for(i in -2..2) draw[topRow+2][topColumn+i] = '*'
        return
    }
    val nextHeight = height / 2
    drawTriangle(topRow, topColumn, nextHeight, draw)
    drawTriangle(topRow + nextHeight, topColumn - nextHeight, nextHeight, draw)
    drawTriangle(topRow + nextHeight, topColumn + nextHeight, nextHeight, draw)
}