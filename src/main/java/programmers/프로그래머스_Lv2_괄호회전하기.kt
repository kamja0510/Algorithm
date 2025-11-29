package programmers

class RotateBracket {
    fun solution(s: String): Int {
        var answer: Int = 0
        val stack = ArrayDeque<Char>()
        val length = s.length
        for(x in 0..<length){
            var isCorrect = true
            for(i in 0..<length){
                val currentChar = s[(x+i)%length]
                when(currentChar){
                    ']' -> {
                        if(stack.lastOrNull() == '[') stack.removeLast() else {
                            stack.clear()
                            isCorrect = false
                            break
                        }
                    }
                    '}' -> {
                        if(stack.lastOrNull() == '{') stack.removeLast() else {
                            stack.clear()
                            isCorrect = false
                            break
                        }
                    }
                    ')' -> {
                        if(stack.lastOrNull() == '(') stack.removeLast() else {
                            stack.clear()
                            isCorrect = false
                            break
                        }
                    }
                    else -> stack.addLast(currentChar)
                }
            }
            if(stack.size == 0 && isCorrect) answer++
        }

        return answer
    }
}

fun main(){
    val solution = RotateBracket()
    solution.solution("}]()[{").toString().let { println(it) }
    solution.solution("[](){}").toString().let { println(it) }
}