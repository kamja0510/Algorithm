package baekjoon.barkingdog.array

fun main(){
    var multipleNumber = 1
    val numbers = IntArray(10)
    repeat(3){
        multipleNumber *= readln().toInt()
    }

    multipleNumber.toString().forEach{
        numbers[it.code - '0'.code]++
    }

    val result = buildString {
        numbers.forEach {
            append(it)
            appendLine()
        }
    }

    print(result)
}
// 12372KB 72ms