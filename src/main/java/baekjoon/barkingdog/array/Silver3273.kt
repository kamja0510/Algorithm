package baekjoon.barkingdog.array

import java.util.StringTokenizer

fun main(){
    System.`in`.bufferedReader().use{ br ->
        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        val sum = br.readLine().toInt()

        val numbers = ByteArray(1000002)
        while(st.hasMoreTokens()){
            numbers[st.nextToken().toInt()]++
        }

        var count = 0
        numbers.forEachIndexed { index, value ->
            val other = sum - index
            if (other in numbers.indices && value.toInt() == 1 && numbers[other].toInt() == 1) {
                count++
            }
        }

        print(count/2)
    }
}