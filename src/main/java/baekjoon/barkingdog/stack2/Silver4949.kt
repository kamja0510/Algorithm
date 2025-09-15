package baekjoon.barkingdog.stack2

fun main(){
    val bw = System.`out`.bufferedWriter()
    while(true){
        val stack = ArrayDeque<Char>()
        var isBalanced = true
        val string = readln()
        if(string == ".") break
        string.forEach{
            when(it){
                '(' -> { stack.addLast('(') }
                '[' -> { stack.addLast('[') }
                ')' -> { if(stack.lastOrNull() == '(') stack.removeLast() else { isBalanced = false; return@forEach} }
                ']' -> { if(stack.lastOrNull() == '[') stack.removeLast() else { isBalanced = false; return@forEach} }
                else ->{}
            }
        }
        if(isBalanced && stack.isEmpty()){
            bw.write("yes")
        }else{
            bw.write("no")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}