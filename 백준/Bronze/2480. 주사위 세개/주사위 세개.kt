import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val count = IntArray(7) // 주사위는 1-6

    while(st.hasMoreTokens()) {
        count[st.nextToken().toInt()]++
    }

    val uniqueCount = count.count { it > 0 }
    val result = when (uniqueCount) {
        3 -> count.indexOfLast { it > 0 } * 100
        2 -> 1_000 + count.indexOfFirst { it == 2 } * 100
        1 -> 10_000 + count.indexOfFirst { it > 0 } * 1_000
        else -> 0
    }

    println(result)
}