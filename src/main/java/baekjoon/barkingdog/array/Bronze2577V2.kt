package baekjoon.barkingdog.array

fun main(){
    var product = 1
    val numbers = IntArray(10)
    repeat(3){
        product *= readln().toInt()
    }

    while(product != 0){
        numbers[product%10]++
        product /= 10
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