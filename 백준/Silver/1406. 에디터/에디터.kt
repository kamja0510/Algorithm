package baekjoon.barkingdog.linkedList

import java.util.LinkedList
import java.util.StringTokenizer

fun main(){
    System.`in`.bufferedReader().use{ br ->
        val linkedList = LinkedList<Char>()
        br.readLine().forEach { linkedList.add(it) }
        val iterator = linkedList.listIterator(linkedList.size)

        val m = br.readLine().toInt()

        repeat(m){
            val st = StringTokenizer(br.readLine())
            val command = st.nextToken()

            when(command) {
                "L" -> {
                    if(iterator.hasPrevious()) iterator.previous()
                }
                "D" -> {
                    if(iterator.hasNext()) iterator.next()
                }
                "B" -> {
                    if(iterator.hasPrevious()){
                        iterator.previous()
                        iterator.remove()
                    }
                }
                "P" -> {
                    val alphabet = st.nextToken()
                    iterator.add(alphabet[0])
                }
            }
        }
        val result = buildString {
            linkedList.forEach { append(it) }
        }
        println(result)
    }
}