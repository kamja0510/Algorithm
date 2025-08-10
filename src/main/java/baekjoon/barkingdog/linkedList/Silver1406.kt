package baekjoon.barkingdog.linkedList

import java.util.LinkedList

fun main(){
    System.`in`.bufferedReader().use{ br ->
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
                    command.getOrNull(2)?.let {
                        iterator.add(it)
                    }
                }
            }
        }
        val result = buildString(linkedList.size) {
            linkedList.forEach { append(it) }
        }
        println(result)
    }
}