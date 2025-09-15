package baekjoon.barkingdog.stack2

fun main(){
    val numberOfCase = readln().toInt()
    var answer = 0
    repeat(numberOfCase){
        val string = readln()
        val stack = ArrayDeque<Char>()
        for (char in string) {
                if (stack.isNotEmpty() && stack.last() == char) {
                        stack.removeLast()
                    } else {
                        stack.addLast(char)
                    }
            }
        if(stack.isEmpty()) answer++
    }
    println(answer)
}