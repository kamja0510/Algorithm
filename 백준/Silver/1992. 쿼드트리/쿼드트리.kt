package baekjoon.barkingdog.recursion

fun main(){
    val size = readln().toInt()
    val display = Array(size){
        readln()
    }
    val sb = StringBuilder()
    quadTree(0, 0,  size, display, sb)
    print(sb.toString())
}

fun quadTree(
    startRow: Int,
    startColumn: Int,
    size: Int,
    display: Array<String>,
    sb: StringBuilder,
){
    val binary = display[startRow][startColumn]
    if(size == 1){
        sb.append(binary)
        return
    }
    val nextSize = size / 2
    for(row in startRow..<startRow + size){
        for(column in startColumn..<startColumn + size){
            if(binary != display[row][column]){
                sb.append("(")
                for(i in 0..<2){
                    for(j in 0..<2){
                        quadTree(startRow + nextSize * i, startColumn + nextSize * j, nextSize, display, sb)
                    }
                }
                sb.append(")")
                return
            }
        }
    }
    sb.append(binary)
    return
}
