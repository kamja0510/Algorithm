package baekjoon.barkingdog.linkedList

import java.util.LinkedList
import java.util.StringTokenizer

fun main(){
    System.`in`.bufferedReader().use{ br ->
        System.`out`.bufferedWriter().use { bw ->
            val linkedList = LinkedList<Char>()
            val iterator = linkedList.listIterator()
            while (true) {
                val alphabet = br.read().toChar()
                if (alphabet == '\n') break
                iterator.add(alphabet)
            }

            val m = br.readLine().toInt()

            repeat(m) {
                val command = br.readLine()

                when (command[0]) {
                    'L' -> {
                        if (iterator.hasPrevious()) iterator.previous()
                    }

                    'D' -> {
                        if (iterator.hasNext()) iterator.next()
                    }

                    'B' -> {
                        if (iterator.hasPrevious()) {
                            iterator.previous()
                            iterator.remove()
                        }
                    }

                    'P' -> {
                        val alphabet = command[2]
                        iterator.add(alphabet)
                    }
                }
            }
            val result = buildString {
                linkedList.forEach { append(it) }
            }
            bw.write(result)
        }
    }
}