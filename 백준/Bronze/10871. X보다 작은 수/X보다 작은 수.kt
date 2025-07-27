import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    repeat(n){
        val number = st.nextToken().toInt()
        if(number < x) bw.write("$number ")
    }

    bw.flush()
}