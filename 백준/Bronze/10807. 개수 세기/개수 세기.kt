package baekjoon.barkingdog.array

import java.util.StringTokenizer

fun main(){
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine()
        val st = StringTokenizer(br.readLine())
        val target = br.readLine().toByte()

        var count = 0
        while(st.hasMoreTokens()){
            if(st.nextToken().toByte() == target) count++
        }
        print(count)
    }
}