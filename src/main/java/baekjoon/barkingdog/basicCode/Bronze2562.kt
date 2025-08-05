package baekjoon.barkingdog.basicCode

fun main(){
    var max = 0
    var maxIndex = 0
    for(i in 1..9){
        val n = readln().toInt()
        if(n > max){
            max = n
            maxIndex = i
        }
    }
    println(max)
    println(maxIndex)
}