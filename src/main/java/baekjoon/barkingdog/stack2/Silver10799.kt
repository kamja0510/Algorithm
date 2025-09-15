package baekjoon.barkingdog.stack2

fun main(){
    val parentheses = readln()
    val stack = ArrayDeque<Char>()
    var answer = 0
    parentheses.forEachIndexed{ index, parenthesis ->
        when(parenthesis){
            '(' -> {
                stack.addLast('(')
            }
            ')' -> {
                if(parentheses[index-1] == '(') {
                    stack.removeLast()
                    answer += stack.size
                }else{
                    stack.removeLast()
                    answer += 1
                }
            }
        }
    }
    println(answer)
}