class Solution {
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