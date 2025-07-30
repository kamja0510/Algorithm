package performanceTest

import kotlin.system.measureNanoTime

fun main() {
    val iterations = 100_000
    val repeats = 100
    val text = "Hello"

    var stringBuilderTotal = 0L
    var stringBufferTotal = 0L
    var buildStringTotal = 0L

    repeat(repeats) {
        // 1. StringBuilder
        stringBuilderTotal += measureNanoTime {
            val sb = StringBuilder()
            repeat(iterations) {
                sb.append(text)
            }
            sb.toString()
        }

        // 2. StringBuffer
        stringBufferTotal += measureNanoTime {
            val sb = StringBuffer()
            repeat(iterations) {
                sb.append(text)
            }
            sb.toString()
        }

        // 3. buildString
        buildStringTotal += measureNanoTime {
            buildString {
                repeat(iterations) {
                    append(text)
                }
            }
        }
    }

    println("===== 평균 실행 시간 (100회 반복) =====")
    println("StringBuilder 평균: ${stringBuilderTotal / repeats} ns")
    println("StringBuffer  평균: ${stringBufferTotal / repeats} ns")
    println("buildString   평균: ${buildStringTotal / repeats} ns")
}
