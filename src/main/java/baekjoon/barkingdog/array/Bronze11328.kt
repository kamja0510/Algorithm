package baekjoon.barkingdog.array

import java.util.*

fun main() {
    System.`in`.bufferedReader().use { br ->
        val t = readln().toInt()
        val result = buildString {
            repeat(t) {
                val charArray = ShortArray(26)
                val st = StringTokenizer(br.readLine())
                val oldString = st.nextToken()
                val newString = st.nextToken()
                oldString.forEach {
                    charArray[it.code-'a'.code]++
                }
                newString.forEach {
                    charArray[it.code-'a'.code]--
                }
                val filteredSize = charArray.filterNot { it.toInt() == 0 }.size
                if(filteredSize == 0) append("Possible") else append("Impossible")
                appendLine()
            }
        }
        print(result)
    }
}