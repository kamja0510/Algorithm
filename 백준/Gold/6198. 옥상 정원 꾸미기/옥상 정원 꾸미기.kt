package baekjoon.barkingdog.stack

fun main(){
    val numberOfBuildings = readln().toInt()

    val stack = ArrayDeque<Building>()
    val heights = IntArray(numberOfBuildings){ readln().toInt() }
    var answer: Long = 0

    for(i in numberOfBuildings-1 downTo 0){
        var count = 0
        while(stack.isNotEmpty() && stack.last().height < heights[i]){
            count += stack.last().count + 1
            stack.removeLast()
        }
        stack.addLast(Building(height = heights[i], count = count))
        answer += count
    }
    println(answer)
}

data class Building(val height: Int, val count: Int)