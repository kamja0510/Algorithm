package baekjoon

import java.util.PriorityQueue

data class Node1753(
    val number: Int,
    val weight: Int,
)

fun main(){
    // 노드 갯수, 간선 갯수 입력
    val (nodeCount, edgeCount) = readln().split(" ").map{ it.toInt() }
    // 시작 노드 번호 입력
    val start = readln().toInt()
    // 그래프 Array로 선언
    val graph = Array<MutableList<Node1753>>(nodeCount+1){ mutableListOf() }
    // 간선 입력
    repeat(edgeCount){
        val(start, end, weight) = readln().split(" ").map{ it.toInt() }
        graph[start].add(Node1753(number = end, weight = weight))
    }
    val dist = IntArray(nodeCount+1){ Int.MAX_VALUE }
    dist[start] = 0

    val priorityQueue = PriorityQueue<Node1753>(compareBy { it.weight })
    priorityQueue.add(Node1753(number = start, weight = 0))
    while(priorityQueue.isNotEmpty()){
        val currentNode = priorityQueue.poll()
        if(dist[currentNode.number] < currentNode.weight) continue
        
        graph[currentNode.number].forEach { neighbor ->
            val newDist = dist[currentNode.number] + neighbor.weight
            if(newDist < dist[neighbor.number]){
                dist[neighbor.number] = newDist
                priorityQueue.add(Node1753(number = neighbor.number, weight = newDist))
            }
        }
    }
    for(i in 1..nodeCount){
        val answer = if(dist[i] == Int.MAX_VALUE) "INF" else dist[i]
        println(answer)
    }
}