import java.util.*

fun main(){
    print(
        buildString {
            repeat(3){
                val st = StringTokenizer(readln())
                var count = 0
                while(st.hasMoreTokens()){
                    val stomach = st.nextToken()
                    if(stomach == "0") count++
                }
                appendLine(
                    when(count){
                        0 -> "E"
                        1 -> "A"
                        2 -> "B"
                        3 -> "C"
                        4 -> "D"
                        else -> ""
                    }
                )
            }
        }
    )
}