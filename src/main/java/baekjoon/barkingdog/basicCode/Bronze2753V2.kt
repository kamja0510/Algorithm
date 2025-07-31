package baekjoon.barkingdog.basicCode

fun main(){
    val year = readln().toInt()
    print(when{
        year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) -> 1
        else -> 0
    })
}