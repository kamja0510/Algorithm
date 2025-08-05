package baekjoon.barkingdog.basicCode

private val t = java.io.StreamTokenizer(System.`in`.bufferedReader())
private val i get() = t.nextToken().run{t.nval.toInt()}

fun main()=with(System.`out`.bufferedWriter()){
    repeat(i){
        write("${i + i}\n")
    }
    flush()
    close()
}
// 118556KB 556ms