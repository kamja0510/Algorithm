import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val result = buildString {
        appendLine(a+b)
        appendLine(a-b)
        appendLine(a*b)
        appendLine(a/b)
        appendLine(a%b)
    }
    bw.write(result)
    bw.flush()
    bw.close()
}