package programmers

class SliceSquare {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        return (left..right).map{
            val row : Int = (it / n).toInt()
            val column : Int = (it % n).toInt()
            maxOf(row, column)+1
        }.toIntArray()
    }
}

fun main(){
    val solution = SliceSquare()
    println(solution.solution(3,2,5).contentToString())
    println(solution.solution(4,7,14).contentToString())
}