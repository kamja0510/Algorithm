package baekjoon.barkingdog.stack

import java.util.*
import kotlin.collections.ArrayDeque

// n (1<= n <= 10만)
// 높이 (0 <= 높이 <= 10억)
// 직사각형의 넓이 Int 벗어날 수 있음
fun main(){
        while (true) {
            val input = readln()
            if(input == "0") break

            val st = StringTokenizer(input)
            val n = st.nextToken().toInt()
            val heights = IntArray(n+1){
                if(it == n) 0 else st.nextToken().toInt()
            }

            val stack = ArrayDeque<Int>()
            var maxArea = 0L

            var i = 0
            while (i <= n) {
                // 현재 높이보다 높은 막대가 스택에 남아있으면 팝하며 면적 계산
                while (stack.isNotEmpty() && heights[stack.last()] > heights[i]) {
                    val height = heights[stack.removeLast()].toLong()
                    val width = if (stack.isEmpty()) i else i - stack.last() - 1
                    val area = height * width
                    if (area > maxArea) maxArea = area
                }
                stack.addLast(i)
                i++
            }

            println(maxArea)
        }
}