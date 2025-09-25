package baekjoon.barkingdog.backtracking

fun main(){
    val (size, target) = readln().split(" ").map{ it.toInt() }
    val sequence = readln().split(" ").map{ it.toInt() }
    val answer = calculate(sequence, 0, 0, target)
    println(if(target == 0) answer -1 else answer)
}

fun calculate(
    sequence: List<Int>,
    sum: Int,
    step: Int,
    target: Int,
): Int{
    if(step == sequence.size){
        if(sum == target){
            return 1
        }else return 0
    }
    var answer = 0

    answer += calculate(sequence, sum+sequence[step], step+1, target)
    answer += calculate(sequence, sum, step+1, target)

    return answer
}