package performanceTest

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.system.measureTimeMillis

fun main() {
    val repeatCount = 100_000
    val testString = "Hello, Kotlin performance test!"

    println("==== 출력 성능 비교 시작 ====\n")

    // println() 테스트
    val printlnTime = measureTimeMillis {
        repeat(repeatCount) {
            println(testString)
        }
    }

    // BufferedWriter 테스트
    val bufferedWriterTime = measureTimeMillis {
        val bw = System.`out`.bufferedWriter()
        repeat(repeatCount) {
            bw.write(testString)
            bw.newLine() // 줄바꿈
        }
        bw.flush() // 출력 버퍼 비우기
    }

    println("println() 출력 시간: ${printlnTime}ms\n")
    println("BufferedWriter 출력 시간: ${bufferedWriterTime}ms")
}