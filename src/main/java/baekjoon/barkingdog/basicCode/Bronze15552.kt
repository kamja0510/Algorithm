package baekjoon.barkingdog.basicCode

import java.util.StringTokenizer

fun main() {
    System.`in`.bufferedReader().use { br ->
        System.`out`.bufferedWriter().use { bw ->
            val t = br.readLine().toInt()
            repeat(t) {
                val st = StringTokenizer(br.readLine())
                bw.write("${st.nextToken().toInt()+st.nextToken().toInt()}\n")
            }
            bw.flush()
        }
    }
}
// 298460KB 796ms