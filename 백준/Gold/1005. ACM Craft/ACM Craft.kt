package baekjoon

fun main(){
    val testcaseCount = readln().toInt()
    repeat(testcaseCount){
        val (buildingCount, ruleCount) = readln().split(" ").map{ it.toInt() }
        val weights = listOf( 0 ) + readln().split(" ").map{ it.toInt() }
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val inDegree = IntArray(buildingCount + 1)
        repeat(ruleCount){
            val (start, end) = readln().split(" ").map{ it.toInt() }
            graph.getOrPut(start){ mutableListOf() }.add(end)
            inDegree[end]++
        }
        val target = readln().toInt()

        val dp = IntArray(buildingCount + 1){ 0 }
        val queue = ArrayDeque<Node>()
        for(i in 1..buildingCount){
            if(inDegree[i] == 0) {
                queue.add(Node(weights[i],i))
                dp[i] = weights[i]
            }
        }

        while(queue.isNotEmpty()){
            val node = queue.removeFirst()

            graph[node.number]?.forEach {
                inDegree[it]--
                dp[it] = maxOf(dp[it], dp[node.number])
                if(inDegree[it] == 0) {
                    queue.addLast(Node(weights[it],it))
                    dp[it] += weights[it]
                }
            }
        }
        println(dp[target])
    }
}

private data class Node(
    val weight: Int,
    val number: Int,
)