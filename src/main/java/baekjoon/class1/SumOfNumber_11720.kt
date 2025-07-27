package baekjoon.class1

fun main(){
    val n = readln().toInt()
    val number = readln()
    var sum = 0
    for(i in 0..n-1){
        sum += number[i].code-48
    }
    println(sum)
}