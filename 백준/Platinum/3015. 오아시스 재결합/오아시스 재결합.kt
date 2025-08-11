package baekjoon.barkingdog.stack

import java.io.BufferedReader
import java.io.InputStreamReader

// 오른쪽 사람이 왼쪽 사람을 볼 수 있냐를 기준으로 풀이

data class HeightBlock(val height: Int, val count: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var ans = 0L
    val st = ArrayDeque<HeightBlock>()

    repeat(n) {
        val currentHeight = br.readLine().toInt()

        while (st.isNotEmpty() && st.last().height < currentHeight) {
            ans += st.last().count.toLong()
            st.removeLast()
        }

        if (st.isEmpty()) {
            st.addLast(HeightBlock(height = currentHeight, count = 1))
        } else {
            val (topHeight, topCount) = st.last()
            
            if (topHeight == currentHeight) {
                st.removeLast()
                ans += topCount.toLong()
                // 볼 수 있는 블럭이 더 있는 경우
                if (st.isNotEmpty()) ans += 1L
                st.addLast(HeightBlock(height = currentHeight, count = topCount+1))
            } else {
                ans += 1L
                st.addLast(HeightBlock(height = currentHeight, count = 1))
            }
        }
    }

    println(ans)
}