package baekjoon.barkingdog.stack2

fun main(){
    val brackets = readln()
    var answer = 0
    val stack = ArrayDeque<Char>(0)
    var mul = 1
    var isCorrect = true
    for(i in brackets.indices){
        when(brackets[i]){
            '(' -> {
                stack.addLast('(')
                mul *= 2
            }
            '[' -> {
                stack.addLast('[')
                mul *= 3
            }
            ')' -> {
                if(stack.lastOrNull() == '(') {
                    stack.removeLast()
                    mul /= 2
                    if(brackets[i-1] == '(') answer += 2 * mul
                }else{
                    isCorrect = false
                    break
                }
            }
            ']' -> {
                if(stack.lastOrNull() == '[') {
                    stack.removeLast()
                    mul /= 3
                    if(brackets[i-1] == '[') answer += 3 *  mul
                }else{
                    isCorrect = false
                    break
                }
            }
        }
    }
    if(stack.isEmpty() && isCorrect) println(answer) else println(0)
}