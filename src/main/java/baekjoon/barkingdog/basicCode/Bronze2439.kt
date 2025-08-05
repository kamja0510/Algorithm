package baekjoon.barkingdog.basicCode

fun main(){
    val numberOfLines = readln().toInt()
    print(
        buildString{
            for(i in 1..numberOfLines){
                append(" ".repeat(numberOfLines - i)).append("*".repeat(i)).appendLine()
            }
        }
    )
}