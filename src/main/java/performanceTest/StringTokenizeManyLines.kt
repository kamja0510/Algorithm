package performanceTest

import java.util.StringTokenizer
import kotlin.system.measureTimeMillis

fun main() {
    val lineCount = 10_000
    val tokensPerLine = 100
    val lines = List(lineCount) {
        (1..tokensPerLine).joinToString(" ") { (it % 1000).toString() }
    }

    val repeatCount = 100

    var splitTotalTime = 0L
    var splitResultSum = 0L

    var tokenizerTotalTime = 0L
    var tokenizerResultSum = 0L

    repeat(repeatCount) {
        var sum = 0L
        val time = measureTimeMillis {
            for (line in lines) {
                val tokens = line.split(" ")
                for (token in tokens) {
                    sum += token.toInt()
                }
            }
        }
        splitTotalTime += time
        splitResultSum = sum
    }

    repeat(repeatCount) {
        var sum = 0L
        val time = measureTimeMillis {
            for (line in lines) {
                val tokenizer = StringTokenizer(line, " ")
                while (tokenizer.hasMoreTokens()) {
                    sum += tokenizer.nextToken().toInt()
                }
            }
        }
        tokenizerTotalTime += time
        tokenizerResultSum = sum
    }

//    println("split() 결과 합: $splitResultSum")
    println("split() 평균 시간: ${splitTotalTime / repeatCount}ms\n")

//    println("StringTokenizer 결과 합: $tokenizerResultSum")
    println("StringTokenizer 평균 시간: ${tokenizerTotalTime / repeatCount}ms\n")
}
