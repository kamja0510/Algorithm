package baekjoon.barkingdog.basicCode

import java.util.*

fun main() {
    System.`in`.bufferedReader().use{ br ->
        System.`out`.bufferedWriter().use { bw ->
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val c = st.nextToken().toInt()

            val arr = intArrayOf(a, b, c)

            for(i in arr.indices){
                if(i == arr.size -1) break
                if(arr[i] > arr[i+1]){
                    val t = arr[i+1]
                    arr[i+1] = arr[i]
                    arr[i] = t
                }
                if(i == 0){
                    if(arr[i] > arr[i+2]){
                        val t = arr[i+2]
                        arr[i+2] = arr[i]
                        arr[i] = t
                    }
                }
            }
            arr.forEach { bw.write("$it ") }
        }
    }
}