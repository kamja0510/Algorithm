package baekjoon.barkingdog.linkedList

fun main() {
    val (n,k) = readln().split(' ').map(String::toInt)
    val circularLinkedList = CircularLinkedList<Int>()
    (1..n).forEach{ circularLinkedList.add(it)}
    buildString {
        append('<')
        while(circularLinkedList.getSize() > 0){
            append(circularLinkedList.removeNext(k))
            if(circularLinkedList.getSize() != 0)append(", ")
        }
        append('>')
    }.run(::println)
}

class CircularLinkedList<T> {
    data class Node<T>(
        val value: T,
        var next: Node<T>? = null,
    )

    private var tail: Node<T>? = null
    private var cur: Node<T>? = null
    private var size = 0

    fun add(value: T){
        val newNode = Node(value)
        if(tail == null) {
            tail = newNode
            newNode.next = tail
        }
        else{
            newNode.next = tail!!.next
            tail!!.next = newNode
            tail = newNode
        }
        cur = tail
        size++
    }

    fun removeNext(step: Int = 1): T{
        repeat(step-1){
            cur = cur!!.next
        }
        val after: Node<T>? = cur!!.next
        cur!!.next = after!!.next
        size--
        return after.value
    }

    fun getSize(): Int = size
}