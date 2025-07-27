package baekjoon.class1

fun main(args : Array<String>){
    val testCase = readln().toInt()
    repeat(testCase){
        val scoreBoard = readln()
        var score = 0
        var oValue = 1
        scoreBoard.forEach{
            if (it=='O') {
                score+=oValue
                oValue++
            }else{
                oValue = 1
            }
        }
        println(score)
    }
}