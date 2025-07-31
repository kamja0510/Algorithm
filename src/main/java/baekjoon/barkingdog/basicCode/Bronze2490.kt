package baekjoon.barkingdog.basicCode

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
                    charArrayOf('E','A','B','C','D')[count]
                )
            }
        }
    )
}
// 12340KB, 76ms