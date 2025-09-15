package baekjoon.barkingdog.stack2

fun main(){
    val caseCount = readln().toInt()
    val bw = System.`out`.bufferedWriter()
    repeat(caseCount){
        val stack = ArrayDeque<Char>()
        val parentheses = readln()
        var isCorrect = true
        for(parenthesis in parentheses){
            when(parenthesis){
                '(' -> { stack.addLast('(') }
                ')' -> { if(stack.lastOrNull() == '(') stack.removeLast() else { isCorrect = false; break}}
            }
        }
        if(isCorrect && stack.isEmpty()) {
            bw.write("YES")
        }else{
            bw.write("NO")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}