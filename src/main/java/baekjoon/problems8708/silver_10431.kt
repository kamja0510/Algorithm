package baekjoon.problems8708

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numberOfTestCase = br.readLine().toInt()
    repeat(numberOfTestCase){
        val linkedList = LinkedList<Int>()
        val list = br.readLine().split(" ").map{ it.toInt() }
        bw.append(list[0].toString() + " ")
        val order = list.drop(1)
        var max = -1
        var count = 0
        order.forEachIndexed { index, height ->
            if(max < height){
                linkedList.add(height)
                max = height
            }else {
                val insertIndex = linkedList.indexOfFirst { it  > height }
                linkedList.add(insertIndex, height)
                count += index - insertIndex
            }
        }
        bw.append(count.toString() + "\n")
    }
    bw.flush()
    bw.close()
}

/*
* 1 0 1
* 2 0 2
* 2 1 1
* 3 0 3
* */