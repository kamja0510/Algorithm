package programmers

class TangerinePicker {
    fun solution1(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0

        var numberOfTangerine = tangerine.size
        val countTangerine = mutableMapOf<Int,Int>()

        for (i in 0 until numberOfTangerine) {
            countTangerine[tangerine[i]] = countTangerine.getOrDefault(tangerine[i], 0) + 1
        }

        val sortedCount = countTangerine.values.sorted()
        answer = sortedCount.size
        for(i in sortedCount.indices){
            numberOfTangerine -= sortedCount[i]
            if(numberOfTangerine < k){
                break
            }
            answer -= 1
        }

        return answer
    }

    fun solution2(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var limit = 0
        tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }.forEach{
            if(limit >= k){
                return answer
            }
            limit += it.second.size
            answer++
        }

        return answer
    }

    fun solution3(k: Int, tangerine: IntArray): Int {
        return tangerine.groupBy { it } // {1=[1], 3=[3, 3], 2=[2, 2], 5=[5, 5], 4=[4]}
            .values
            .sortedByDescending{ it.size }
            .map { Pair(0, it.size) }
            .fold(Pair(0, 0)) { acc, (_, size) ->
                if (acc.second >= k) acc else Pair(acc.first + 1, acc.second + size)
            }
            .first
    }
}

fun main(){
    val tangerinePicker = TangerinePicker()
    val k = 6
    val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    println(tangerinePicker.solution1(k, tangerine)) // Expected output: 3
    println(tangerinePicker.solution2(k, tangerine)) // Expected output: 3
    println(tangerinePicker.solution3(k, tangerine)) // Expected output: 3
}
