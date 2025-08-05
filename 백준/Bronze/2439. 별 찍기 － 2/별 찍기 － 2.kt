import java.util.*

fun main(args : Array<String>){
    val num = readln().toInt()
    var count = 1
    repeat(num){
        val sb = StringBuffer()
        repeat(num-count){
            sb.append(" ")
        }
        repeat(count){
            sb.append("*")
        }
        println("${sb}")
        count++
    }
}