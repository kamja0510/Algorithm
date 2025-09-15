package baekjoon.barkingdog.stack2

fun main(){
    val numberOfCase = readln().toInt()
    var answer = 0
    repeat(numberOfCase){
        val string = readln()
        val stack = ArrayDeque<Char>()
        string.forEach{
            when(it){
                'A', 'B' -> {
                    if(stack.lastOrNull() == it){
                        stack.removeLast()
                    }else{
                        stack.addLast(it)
                    }
                }
                else -> {}
            }
        }
        if(stack.isEmpty()) answer++
    }
    println(answer)
}