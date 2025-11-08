class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        println(target)
        
        fun dfs(
            depth: Int,
            sum: Int,
        ){
            if(depth == numbers.size){
                if(sum == target) answer++
                return
            }
            
            dfs(depth+1, sum + numbers[depth])
            dfs(depth+1, sum - numbers[depth])
        }
        
        dfs(0, 0)
        
        return answer
    }
    
}

