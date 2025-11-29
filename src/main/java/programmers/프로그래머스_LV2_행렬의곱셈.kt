package programmers

class MatrixMultiplication {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val n = arr1.size
        val m = arr2[0].size
        val answer = Array(n){
            IntArray(m)
        }

        for(row in 0 until n){
            for(column in 0 until m){
                var sum = 0
                arr1[row].forEachIndexed{ index, number ->
                    sum += number * arr2[index][column]
                }
                answer[row][column] = sum
            }
        }
        return answer
    }
}

fun main(){
    val solution = MatrixMultiplication()
    println(solution.solution(
        arr1 = "[[1, 4], [3, 2], [4, 1]]".to2DIntArray(),
        arr2 = "[[3, 3], [3, 3]]".to2DIntArray()
    ).contentDeepToString())
    println(solution.solution(
        arr1 = "[[2, 3, 2], [4, 2, 4], [3, 1, 4]]".to2DIntArray(),
        arr2 = "[[5, 4, 3], [2, 4, 1], [3, 1, 1]]".to2DIntArray()
    ).contentDeepToString())
}