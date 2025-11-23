package programmers

class NLcm {
    fun solution(arr: IntArray): Int {
        var answer = 0

        answer = arr.reduce { acc, num ->
            lcm(acc, num)
        }
        return answer
    }

    fun gcd(a: Int, b: Int): Int {
        return if(b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return a * b / gcd(a, b)
    }
}

fun main() {
    val nLcm = NLcm()
    val arr1 = intArrayOf(2, 6, 8, 14)
    val arr2 = intArrayOf(1, 2, 3)
    val arr3 = intArrayOf(4, 6, 8)
    println(nLcm.solution(arr1)) // 168
    println(nLcm.solution(arr2)) // 6
    println(nLcm.solution(arr3)) // 24
}