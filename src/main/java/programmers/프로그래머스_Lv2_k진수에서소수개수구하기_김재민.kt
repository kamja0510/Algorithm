package programmers

import java.util.StringTokenizer

fun solution(n: Int, k: Int): Int {
    val toBaseK = n.toString(k)
    val st = StringTokenizer(toBaseK,"0")
    val numbersWithNoZero = st.toList()

    val primeNumbers = numbersWithNoZero.count { isPrimeString(it.toString()) }

    val answer: Int = primeNumbers
    return answer
}

fun isPrimeString(numString: String): Boolean {
    val num = numString.toLong()    // Long으로 해줘야함.
    if (num <= 1) return false

    return (2..Math.sqrt(num.toDouble()).toInt()).none { num % it == 0L }
}

fun main(args:Array<String>){
    solution(437674,3)
}