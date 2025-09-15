package baekjoon.barkingdog.stack2

import kotlin.math.pow

fun main(){
    val brackets = readln()
    var answer = 0
    val stack = ArrayDeque<Char>(0)
    var parenthesesCount = 0
    var bracketsCount = 0
    var isCorrect = true
    for(i in brackets.indices){
        when(brackets[i]){
            '(' -> {
                stack.addLast('(')
                parenthesesCount++
            }
            '[' -> {
                stack.addLast('[')
                bracketsCount++
            }
            ')' -> {
                if(stack.lastOrNull() == '(') {
                    stack.removeLast()
                    parenthesesCount--
                    if(brackets[i-1] == '(') answer += 2 *  2.0.pow(parenthesesCount).toInt() * 3.0.pow(bracketsCount).toInt()
                }else{
                    isCorrect = false
                    break
                }
            }
            ']' -> {
                if(stack.lastOrNull() == '[') {
                    stack.removeLast()
                    bracketsCount--
                    if(brackets[i-1] == '[') answer += 3 *  2.0.pow(parenthesesCount).toInt() * 3.0.pow(bracketsCount).toInt()
                }else{
                    isCorrect = false
                    break
                }
            }
        }
    }
    if(stack.isEmpty() && isCorrect) println(answer) else println(0)
}