package baekjoon.problems8708

fun main(){
    val input = readln()
    input.findMostAlphabet()
}

private fun String.findMostAlphabet(){
    // 알파벳 개수는 26개
    // a~z 26개짜리 배열 만들어서 각 배열 인덱스에 카운팅
    // 배열 돌면서 max값 찾으면서 만약 현재 max값과 겹치면 중복이라고 표시, 또 새로운 max값이 발견된다면 중복 체크해제 및 max값 최신화

    val alphabetList = MutableList(26){ 0 }
    forEach { alphabet ->
        val index = alphabet.lowercaseChar().code - 97
        alphabetList[index]++
    }

    var maxCount = 0
    var maxIndex = 0
    var isAlreadyExist = false
    alphabetList.forEachIndexed{ index, count ->
        if(count > maxCount){
            maxCount = count
            maxIndex = index
            isAlreadyExist = false
        }else if(count == maxCount){
            isAlreadyExist = true
        }
    }

    if(isAlreadyExist) println("?") else println(('A'+maxIndex))
}