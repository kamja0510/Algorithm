package baekjoon.barkingdog.linkedList

fun main() {
    System.`in`.bufferedReader().use { br ->
        repeat(br.readLine().toInt()){
            val password = br.readLine()

            val left = ArrayDeque<Char>()
            val right = ArrayDeque<Char>()

            password.forEach{ char ->
                when(char){
                    '-' -> {
                        if(left.isNotEmpty()) left.removeLast()
                    }
                    '<' -> {
                        if(left.isNotEmpty()) right.addFirst(left.removeLast())
                    }
                    '>' -> {
                        if(right.isNotEmpty())left.addLast(right.removeFirst())
                    }
                    else -> {
                        left.addLast(char)
                    }
                }
            }

            val result = buildString(left.size + right.size){
                left.forEach{append(it)}
                right.forEach{append(it)}
            }

            println(result)
        }
    }
}