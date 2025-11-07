package baekjoon.barkingdog.twopointer

fun main(){
    val (n, s) = readln().split(" ").map{ it.toInt() }
    val numbers= readln().split(" ").map{it. toInt() }

    var start = 0
    var end = 0
    var sum = numbers[0]
    var answer = Int.MAX_VALUE

    while(end in start..<n){
        if(sum >= s){
            answer = minOf(answer, end - start + 1)
            sum -= numbers[start++]
        }else {
            if(end == n - 1) break
            sum += numbers[++end]
        }
    }

    print(if(answer== Int.MAX_VALUE) 0 else answer)
}