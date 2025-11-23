package programmers

class ContinuousSubsequenceSum {
    fun solution(elements: IntArray): Int {
        var answer: Int = 0
        val set = mutableSetOf<Int>()
        val size = elements.size

        elements.forEachIndexed{ index, num ->
            var sum = 0
            repeat(size){ time ->
                sum += elements[(index + time) % size]
                set.add(sum)
            }
        }

        answer = set.size

        return answer
    }
}

fun main(){
    val solution = ContinuousSubsequenceSum()
    val arr = intArrayOf(7,9,1,1,4)
    println(solution.solution(arr))
}