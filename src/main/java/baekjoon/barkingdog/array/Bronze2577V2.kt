package baekjoon.barkingdog.array

fun main(){
    var multipleNumber = 1
    val numbers = IntArray(10)
    repeat(3){
        multipleNumber *= readln().toInt()
    }

    while(multipleNumber != 0){
        numbers[multipleNumber%10]++
        multipleNumber /= 10
    }

    val result = buildString {
        numbers.forEach {
            append(it)
            appendLine()
        }
    }

    print(result)
}
// 12344KB 72ms