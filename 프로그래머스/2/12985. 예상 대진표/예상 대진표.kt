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
}