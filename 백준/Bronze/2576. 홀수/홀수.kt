package baekjoon.barkingdog.basicCode

fun main() {
    var oddSum = 0
    var oddMin = 101
    repeat(7){
        val number = readln().toInt()
        if(number % 2 == 1){
            oddSum += number
            if (number < oddMin) oddMin = number
        }
    }
    if(oddSum == 0){
        println(-1)
    }else{
        println(oddSum)
        println(oddMin)
    }
}