package baekjoon

fun main(){
    val n = readln().toLong()
    var target = readln().toLong()
    var answer = 0L
    var start = 1L
    var end = n * n
    while(start <= end){
        if(start == end){
            answer = start
            break
        }
        val mid = (start + end) / 2
        val count = countLessOrEqual(mid, n)
        if(count < target) start = mid+1
        else end = mid
    }

    println(answer)
}

private fun countLessOrEqual(x: Long, n: Long) : Long{
    var count = 0L
    for(i in 1..n){
        count += minOf(x / i, n)
    }
    return count
}