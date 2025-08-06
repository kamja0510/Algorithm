package baekjoon.barkingdog.array

fun main(){
    var product = 1
    val numbers = IntArray(10)
    repeat(3){
        product *= readln().toInt()
    }

    product.toString().forEach{
        numbers[it.digitToInt()]++
    }

    val result = buildString {
        numbers.forEach {
            append(it)
            appendLine()
        }
    }

    print(result)
}
// 12752KB 84ms