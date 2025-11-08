class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        
        val visited = BooleanArray(n)
        val graph = Array(n) { mutableListOf<Int>() }
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j && computers[i][j] == 1)
                    graph[i].add(j)
            }
        }
        
        val queue = ArrayDeque<Int>()
        for(i in 0..n-1){
            if(visited[i]) continue
            
            queue.addLast(i)
            visited[i] = true
            while(queue.isNotEmpty()){
                val now = queue.removeFirst()
                
                for(i in graph[now]){
                    if(!visited[i]){
                        queue.add(i)
                        visited[i] = true
                    }
                }
            }
            
            answer++
        }
        return answer
    }
}