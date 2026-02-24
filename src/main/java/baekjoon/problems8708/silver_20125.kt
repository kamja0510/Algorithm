package baekjoon.problems8708


/**
 * 가장 먼저 발견되는 별이 머리
 * 그다음 행에서 가장 먼저 발견되는 별이 왼쪽 팔 끝,  가장 늦게 발견되는 별이 오른 팔 끝
 * 머리의 열에서 별이 안보이는 순간 허리끝, 다리 시작
 * 다리의 열에서 끝 행에 도달하거나 별이 보이지 않으면 다리 끝
 */

private data class Coordinate(
    val x: Int,
    val y: Int,
)

fun main(){
    val size = readln().toInt()

    val matrix = Array(size){
        readln()
    }

    measureBodyMetrics(matrix)
}

private fun measureBodyMetrics(
    matrix: Array<String>
) {
    val head: Coordinate  = findHead(matrix)
    val heart = Coordinate(head.x , head.y + 1)

    val leftArmLength = heart.x - matrix[heart.y].indexOfFirst{ it == '*'}
    val rightArmLength = matrix[heart.y].indexOfLast{ it == '*'} - heart.x
    val waistLength = measureWaistLength(matrix, heart)
    val (leftLegLength, rightLegLength) = measureLegsLength(matrix, Coordinate(heart.x, heart.y + waistLength))

    println("${heart.y+1} ${heart.x+1}")
    println("$leftArmLength $rightArmLength $waistLength $leftLegLength $rightLegLength")
}

private fun findHead(
    matrix: Array<String>
): Coordinate{
    for(y in matrix.indices){
        for(x in matrix.indices){
            if(matrix[y][x] == '*') return Coordinate(x, y)
        }
    }
    return Coordinate(0,0)
}

private fun measureWaistLength(
    matrix: Array<String>,
    heart: Coordinate,
): Int{
    var startY = heart.y + 1
    var count = 0
    while(matrix[startY][heart.x]=='*'){
        count++
        startY++
    }
    return count
}

private fun measureLegsLength(
    matrix: Array<String>,
    lastOfWaist: Coordinate,
): Pair<Int,Int>{
    var startY = lastOfWaist.y + 1
    var countOfLeft = 0
    var countOfRight = 0

    while(startY < matrix.size  && (matrix[startY][lastOfWaist.x-1]=='*' || matrix[startY][lastOfWaist.x+1]=='*')){
        if(matrix[startY][lastOfWaist.x-1]=='*') countOfLeft++
        if(matrix[startY][lastOfWaist.x+1]=='*') countOfRight++
        startY++
    }

    return Pair(countOfLeft,countOfRight)
}