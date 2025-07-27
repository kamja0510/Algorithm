package baekjoon.class1

fun main(args : Array<String>){
    val a = readln()
    val b = readln()
    val c = readln().toInt()

    val sb = StringBuffer()
    println(a.toInt()+b.toInt()-c)
    println(sb.append(a).append(b).toString().toInt()-c)
}