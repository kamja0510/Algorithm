package baekjoon.barkingdog.array

import java.util.*

fun main() {
    System.`in`.bufferedReader().use { br ->
        val t = br.readLine().toInt()
        val result = buildString {
            repeat(t) {
                val charArray = ShortArray(26)
                val st = StringTokenizer(br.readLine())
                val oldString = st.nextToken()
                val newString = st.nextToken()
                oldString.forEach {
                    charArray[it -'a']++
                }
                newString.forEach {
                    charArray[it-'a']--
                }
                val isPossible = charArray.none { it != 0.toShort() }
                if(isPossible) append("Possible") else append("Impossible")
                appendLine()
            }
        }
        print(result)
    }
}