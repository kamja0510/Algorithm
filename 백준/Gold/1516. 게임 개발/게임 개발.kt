package baekjoon

import java.util.StringTokenizer

fun main(){
    val buildingCount = readln().toInt()
    val graph = List<MutableList<Int>>(buildingCount + 1){mutableListOf<Int>()}
    val weights = IntArray(buildingCount + 1)
    val inDegrees = IntArray(buildingCount + 1)
    val dp = IntArray(buildingCount + 1)
    val queue = ArrayDeque<Int>()
    repeat(buildingCount){ index ->
        val st = StringTokenizer(readln())
        weights[index+1] = st.nextToken().toInt()
        while(true){
            val start = st.nextToken().toInt()
            if(start == -1) break
            graph[start].add(index+1)
            inDegrees[index+1]++
        }
    }

    for(i in 1..buildingCount){
        if (inDegrees[i] == 0) {
            queue.addLast(i)
            dp[i] = weights[i]
        }
    }

    while(queue.isNotEmpty()){
        val node = queue.removeFirst()

        graph[node].forEach { neighbor ->
            dp[neighbor] = maxOf(dp[node], dp[neighbor])
            inDegrees[neighbor]--
            if(inDegrees[neighbor] == 0){
                queue.addLast(neighbor)
                dp[neighbor] += weights[neighbor]
            }
        }
    }

    for(i in 1..buildingCount){
        println(dp[i])
    }
}