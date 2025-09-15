package baekjoon.barkingdog.stack2

fun main(){
    val bw = System.`out`.bufferedWriter()
    while(true){
        val stack = ArrayDeque<Char>()
        var isBalanced = true
        val string = readln()
        if(string == ".") break
        loop@ for (ch in string) {
            when (ch) {
                '(', '[' -> stack.addLast(ch)
                ')' -> if (stack.lastOrNull() == '(') stack.removeLast() else { isBalanced = false; break@loop }
                ']' -> if (stack.lastOrNull() == '[') stack.removeLast() else { isBalanced = false; break@loop } 
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