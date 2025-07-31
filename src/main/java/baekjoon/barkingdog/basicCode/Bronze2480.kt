package baekjoon.barkingdog.basicCode

import java.util.*

fun main(){
    val st = StringTokenizer(readln())

    val map = mutableMapOf<Int, Int>()
    var max = -1
    while(st.hasMoreTokens()){
        val dice = st.nextToken().toInt()
        map[dice] = map.getOrDefault(dice, 0) + 1
        if(dice > max) max = dice
    }

    val result = when{
        map.keys.size == 3 -> max * 100
        map.keys.size == 2 -> 1_000 + map.entries.first { it.value == 2 }.key * 100
        map.keys.size == 1 -> 10_000 + map.keys.first() * 1_000
        else -> 0
    }
    println(result)
}

// 14372KB, 100ms