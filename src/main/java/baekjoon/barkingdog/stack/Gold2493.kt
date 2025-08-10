package baekjoon.barkingdog.stack

fun main() {
    val numberOfTowers = readln().toInt()
    val lengthOfTowers = readln().split(" ").map { it.toInt() }

    val stack = ArrayDeque<Tower>()
    var max = Int.MIN_VALUE

    val result = buildString {
        repeat(numberOfTowers){ time ->
            val currentLength = lengthOfTowers[time]

            if(max < currentLength){
                append(0)
                stack.clear()
                stack.addLast(Tower(time, currentLength))
                max = currentLength
            }else{
                while(true){
                    if(stack.last().length < currentLength){
                        stack.removeLast()
                    }else{
                        append(stack.last().index+1)
                        stack.addLast(Tower(time, currentLength))
                        break
                    }
                }
            }

            append(' ')
        }
    }
    println(result)
}

data class Tower(val index: Int, val length: Int)