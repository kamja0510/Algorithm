package baekjoon.class1

fun main(args : Array<String>){

    val numbers = hashSetOf<Int>()

    repeat(10){
        numbers.add(readln().toInt()%42)
    }

    print(numbers.size)
}