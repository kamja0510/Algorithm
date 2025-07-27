package baekjoon.class1

fun main(args : Array<String>){
    val word = readln()
    val location = IntArray(26) { -1 }
    val sb = StringBuffer()
    var index = 0
    word.forEach{
        val pos = it.code-97
        if(location[pos]==-1) location[pos] = index
        index++
    }
    location.forEach{
        sb.append(it).append(" ")
    }
    print(sb)
}