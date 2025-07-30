package performanceTest

import kotlin.system.measureTimeMillis

fun main() {
    val iterations = 100_000
    val text = "abc"

    // + 연산자
    val plusTime = measureTimeMillis {
        var result = ""
        for (i in 0 until iterations) {
            result += text
        }
    }

    // StringBuilder
    val stringBuilderTime = measureTimeMillis {
        val builder = StringBuilder()
        for (i in 0 until iterations) {
            builder.append(text)
        }
        builder.toString()
    }

    // StringBuffer (스레드 안전)
    val stringBufferTime = measureTimeMillis {
        val buffer = StringBuffer()
        for (i in 0 until iterations) {
            buffer.append(text)
        }
        buffer.toString()
    }

    // buildString 블록
    val buildStringTime = measureTimeMillis {
        val result = buildString {
            for (i in 0 until iterations) {
                append(text)
            }
        }
    }

    println("Execution time (ms):")
    println("+ operator        : $plusTime")
    println("StringBuilder     : $stringBuilderTime")
    println("StringBuffer      : $stringBufferTime")
    println("buildString block : $buildStringTime")
}
