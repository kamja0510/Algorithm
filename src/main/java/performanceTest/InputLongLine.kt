package performanceTest

import java.io.*
import java.nio.charset.StandardCharsets
import java.util.Scanner
import kotlin.system.measureTimeMillis

fun main() {
    val input = (1..100_000).joinToString(" ")

    val repeatCount = 100

    var scannerTotalTime = 0L
    var bufferedReaderTotalTime = 0L
    var readlnTotalTime = 0L

    println("==== 성능 테스트 시작 (100회 반복) ====")

    repeat(repeatCount) { iteration ->
        // System.in 초기화
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        // Scanner 테스트
        val scannerTime = measureTimeMillis {
            val scanner = Scanner(System.`in`)
            var sum = 0L
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt()
            }
            // 결과 출력 생략(시간 측정에 영향 줄 수 있어)
        }
        scannerTotalTime += scannerTime

        // System.in 초기화
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        // BufferedReader + readLine 테스트
        val bufferedReaderTime = measureTimeMillis {
            val reader = System.`in`.bufferedReader()
            val number = reader.readLine().split(" ").map { it.toLong() }
            var sum = number.sum()
            // 결과 출력 생략
        }
        bufferedReaderTotalTime += bufferedReaderTime

        // System.in 초기화
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        // readln() 테스트
        val readlnTime = measureTimeMillis {
            val number = readln().split(" ").map { it.toLong() }
            var sum = number.sum()
            // 결과 출력 생략
        }
        readlnTotalTime += readlnTime
    }

    println("\n==== 테스트 결과 (100회 평균) ====")
    println("Scanner 평균 시간: ${scannerTotalTime / repeatCount} ms")
    println("BufferedReader 평균 시간: ${bufferedReaderTotalTime / repeatCount} ms")
    println("readln() 평균 시간: ${readlnTotalTime / repeatCount} ms")
}