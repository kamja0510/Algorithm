package baekjoon.barkingdog.linkedList

fun main() = System.`in`.bufferedReader().use { br ->
    val left = ArrayDeque<Char>() // 커서 왼쪽
    val right = ArrayDeque<Char>() // 커서 오른쪽

    br.readLine().forEach { left.addLast(it) }

    repeat(br.readLine().toInt()) {
        val cmd = br.readLine()
        when (cmd[0]) {
            'L' -> if (left.isNotEmpty()) right.addFirst(left.removeLast())
            'D' -> if (right.isNotEmpty()) left.addLast(right.removeFirst())
            'B' -> if (left.isNotEmpty()) left.removeLast()
            'P' -> cmd.getOrNull(2)?.let { left.addLast(it) }
        }
    }

    val result = buildString(left.size + right.size) {
        left.forEach { append(it) }
        right.forEach { append(it) }
    }
    println(result)
}