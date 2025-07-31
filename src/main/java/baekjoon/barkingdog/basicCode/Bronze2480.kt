package baekjoon.barkingdog.basicCode

import java.util.*

fun main(){
    val st = StringTokenizer(readln())

    val map = mutableMapOf<Int, Int>()
    var max = -1
    while(st.hasMoreTokens()){
        val dice = st.nextToken().toInt()
        if(map.containsKey(dice)){
            map[dice] = map.getValue(dice) + 1
        }else{
            map[dice] = 1
        }
        if(dice > max) max = dice
    }

    val result = when{
        map.keys.size == 3 -> max * 100
        map.keys.size == 2 -> 1_000 + map.filter { it.value == 2 }.keys.sum() * 100
        map.keys.size == 1 -> 10_000 + map.keys.sum() * 1_000
        else -> 0
    }
    println(result)
}