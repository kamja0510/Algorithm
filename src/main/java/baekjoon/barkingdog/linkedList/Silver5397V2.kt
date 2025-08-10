package baekjoon.barkingdog.linkedList

import java.util.*

fun main() {
    System.`in`.bufferedReader().use { br ->
        System.`out`.bufferedWriter().use { bw ->
            repeat(br.readLine().toInt()){
                val command = br.readLine()

                val password = LinkedList<Char>()
                val iterator = password.listIterator()
                command.forEach { char ->
                    when(char){
                        '-' -> {
                            if (iterator.hasPrevious()){
                                iterator.previous()
                                iterator.remove()
                            }
                        }
                        '<' -> {
                            if(iterator.hasPrevious()) iterator.previous()
                        }
                        '>' -> {
                            if(iterator.hasNext()) iterator.next()
                        }
                        else -> {
                            iterator.add(char)
                        }
                    }
                }

                password.forEach { char ->
                    bw.write(char.toString())
                }
                bw.write("\n")
                bw.flush()
            }
        }
    }
}