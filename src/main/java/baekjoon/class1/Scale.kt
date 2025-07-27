package baekjoon.class1

import java.util.*

fun main(args : Array<String>){
    val st = StringTokenizer(readln())
    val start = st.nextToken().toInt()
    var isAscending = true
    var isDescending = true
    if(start==1){
        for(i in 2..8){
            if(st.nextToken().toInt()!=i){
                print("mixed")
                isAscending = false
                break
            }
        }
        if(isAscending) print("ascending")
    }else if(start==8){
        for(i in 7 downTo 1){
            if(st.nextToken().toInt()!=i){
                print("mixed")
                isDescending = false
                break
            }
        }
        if(isDescending) print("descending")
    }else print("mixed")
}