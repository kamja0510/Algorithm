import java.io.*
import java.util.*

fun main(args : Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    
    print(st.nextToken().toInt() + st.nextToken().toInt())
}