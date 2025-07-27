package baekjoon.class2

import kotlin.math.*

fun main(args : Array<String>){
    val mod = 1234567891
    val length = readln().toInt()
    val string = readln()
    var sum = 0L
    var multipleValue = 1
    string.forEach{
        sum += (it.code-96)*multipleValue%mod
        multipleValue = multipleValue*31%mod
    }
    print(sum%mod)
}