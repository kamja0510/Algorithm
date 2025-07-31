package baekjoon.barkingdog.basicCode

import java.util.*

fun main() {
    System.`in`.bufferedReader().use{ br ->
        System.`out`.bufferedWriter().use { bw ->
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val c = st.nextToken().toInt()

            if (a > b) {
                if (c > a) bw.write("$b $a $c")
                else if (b > c) bw.write("$c $b $a")
                else bw.write("$b $c $a")
            } else {
                if (c < a) bw.write("$c $a $b")
                else if (b < c) bw.write("$a $b $c")
                else bw.write("$a $c $b")
            }
        }
    }
}