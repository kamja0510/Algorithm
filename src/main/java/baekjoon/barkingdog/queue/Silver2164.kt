package baekjoon.barkingdog.queue

fun main(){
    val number = readln().toInt()
    val queue = ArrayDeque<Int>(number)
    (1..number).forEach{ queue.add(it) }
    while(queue.size > 1){
        queue.removeFirst()
        queue.addLast(queue.removeFirst())
    }
    println(queue.get(0))
}