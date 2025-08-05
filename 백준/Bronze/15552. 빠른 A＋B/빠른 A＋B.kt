package baekjoon.barkingdog.basicCode

val t = java.io.StreamTokenizer(System.`in`.bufferedReader())
val i get() = t.nextToken().run{t.nval.toInt()}

fun main()=with(System.`out`.bufferedWriter()){
    repeat(i){
        write("${i + i}\n")
    }
    flush()
    close()
}