package baekjoon

fun main(args: Array<String>){
    while(true){
        val readLine = readln().split(" ").map{it.toInt()}
        if(readLine[0] == 0) break
        val countOfNumbers = readLine[0]
        val numbers = readLine.subList(1,countOfNumbers+1)

        backtrack(depth = 0, startIndex = 0, answer = "", numbers = numbers)
        println()
    }
}

private fun backtrack(
    depth: Int,
    startIndex: Int,
    answer: String,
    numbers: List<Int>
){
    if(depth == 6){
        println(answer)
        return
    }

    for(i in startIndex until numbers.size){
        if(depth + (numbers.size - i) < 6) return
        backtrack(
            depth = depth + 1,
            startIndex = i+1,
            answer = answer + numbers[i] + " ",
            numbers = numbers
        )
    }
}