package baekjoon.barkingdog.linkedList

fun main() {
    repeat(readln().toInt()){
        val password = readln()
        
        val left = ArrayDeque<Char>()
        val right = ArrayDeque<Char>()
        
        password.forEach{ char ->
            when(char){
                '-' -> {
                    if(left.isNotEmpty()) left.removeLast()
                }
                '<' -> {
                    if(left.isNotEmpty()) right.addFirst(left.removeLast())
                }
                '>' -> {
                    if(right.isNotEmpty())left.addLast(right.removeFirst())
                }
                else -> {
                    left.addLast(char)
                }
            }
        }
        
        val result = buildString{
            left.forEach{append(it)}
            right.forEach{append(it)}
        }
        
        println(result)
    }
}