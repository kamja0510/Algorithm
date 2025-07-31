import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    bw.write("${a+b}\n")
    bw.write("${a-b}\n")
    bw.write("${a*b}\n")
    bw.write("${a/b}\n")
    bw.write("${a%b}\n")
    bw.flush()
    bw.close()
}