package baekjoon.problems8708

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numberOfOperation = br.readLine().toInt()
    var set = mutableSetOf<Int>()
    val allSet = Array(20){ index -> index+1}
    repeat(numberOfOperation){
        val line = br.readLine().split(" ")
        val operation = line[0]
        val number = if(line.size == 2) line[1].toInt() else -1
        when(operation){
            "add" -> {
                set.add(number)
            }
            "remove" -> {
                set.remove(number)
            }
            "check" -> {
                if(set.contains(number))bw.append("1\n") else bw.append("0\n")
            }
            "toggle" -> {
                if(set.contains(number)) set.remove(number) else set.add(number)
            }
            "all" -> {
                set = mutableSetOf(*allSet)
            }
            "empty" -> {
                set = mutableSetOf()
            }
        }
    }
    bw.flush()
    bw.close()
}