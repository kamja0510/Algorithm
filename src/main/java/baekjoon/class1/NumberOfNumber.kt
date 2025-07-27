package baekjoon.class1

fun main(args : Array<String>){
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    val numbers = IntArray(10)

    val result = (a*b*c).toString()
    result.forEach{
        it -> numbers[it.code-48]++
    }
    numbers.forEach{
        println(it)
    }

}