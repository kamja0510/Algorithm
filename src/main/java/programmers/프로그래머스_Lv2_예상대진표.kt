package programmers

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1

        var playerA = a
        var playerB = b

        while(true){
            playerA = (playerA + 1) / 2
            playerB = (playerB + 1) / 2
            if(playerA == playerB){
                return answer
            }
            answer++
        }
    }
    //((a - 1) xor (b - 1)) : 1-based 선수 번호를 0-based로 바꿔 XOR. XOR의 최상위 서로 다른 비트 위치가 두 선수가 만나는 라운드를 의미.
    fun solution2(n: Int, a: Int, b: Int) = ((a - 1) xor (b - 1)).toString(2).length
}

fun main() {
    val solution = Solution()
    val n = 8
    val a = 4
    val b = 7
    println(solution.solution(n, a, b)) // Expected output: 3
}