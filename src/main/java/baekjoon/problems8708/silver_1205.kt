package baekjoon.problems8708

/**
 *  자기보다 큰 점수만 세다가 등수가 최대보다 넘어갈 경우 -1 출력
 */
fun main(){
    val (numberOfScore, score, maxRank) = readln().split(" ").map{ it.toInt() }

    if(numberOfScore == 0) println(1)
    else{
        var higherScore = 0
        var sameScore = 0
        readln().split(" ").map{ it.toInt() }.forEach{
            if(it > score) higherScore++
            else if(it == score) sameScore++
        }

        val rank = higherScore + 1
        if(rank + sameScore > maxRank) println(-1) else println(rank)
    }
}