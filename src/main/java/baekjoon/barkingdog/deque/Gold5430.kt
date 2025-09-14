package baekjoon.barkingdog.deque

fun main(){
    val numberOfTestCase = readln().toInt()
    repeat(numberOfTestCase){
        val commandSequence = readln()
        val sizeOfArray = readln().toInt()
        val arrayString = readln()
        if(commandSequence.count { it == 'D'} > sizeOfArray){
            println("error")
            return@repeat
        }
        val deque =
            ArrayDeque(
                arrayString.slice(1..<arrayString.length-1).split(",")
            )


        var isReverse = false
        var index = 0
        while(index < commandSequence.length){
            val command = commandSequence[index]
            when(command){
                'R' -> {
                    isReverse = !isReverse
                    index++
                }
                'D' -> {
                    if(isReverse){
                        deque.removeLast()
                    }else{
                        deque.removeFirst()
                    }
                    index++
                }
                else -> {}
            }
        }
        val result =
            if(isReverse){
                deque.reversed().joinToString(separator = ",", postfix = "]", prefix="[")
            }else{
                deque.joinToString(separator = ",", postfix = "]", prefix="[")
            }
        println(result)
    }
}