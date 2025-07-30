import java.util.StringTokenizer
import kotlin.system.measureTimeMillis

fun main() {
    val input = (1..100_000).joinToString(" ")

    println("입력 문자열 길이: ${input.length}")

    var splitTotalTime = 0L
    var tokenizerTotalTime = 0L

    repeat(100) { iteration ->
        val splitTime = measureTimeMillis {
            val tokens = input.split(" ")
            var sum = 0L
            for (token in tokens) {
                sum += token.toLong()
            }
            if (iteration == 0) println("split() 결과 합: $sum")
        }
        splitTotalTime += splitTime

        val tokenizerTime = measureTimeMillis {
            val tokenizer = StringTokenizer(input, " ")
            var sum = 0L
            while (tokenizer.hasMoreTokens()) {
                sum += tokenizer.nextToken().toLong()
            }
            if (iteration == 0) println("StringTokenizer 결과 합: $sum")
        }
        tokenizerTotalTime += tokenizerTime
    }

    val avgSplitTime = splitTotalTime / 100.0
    val avgTokenizerTime = tokenizerTotalTime / 100.0

    println("split() 평균 수행 시간: %.2f ms".format(avgSplitTime))
    println("StringTokenizer 평균 수행 시간: %.2f ms".format(avgTokenizerTime))
}