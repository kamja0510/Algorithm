package baekjoon.barkingdog.basicCode

fun main(){
    val n = readln().toInt()
    
    val result = buildString{
        for(i in n downTo 1){
            repeat(i){append("*")}
            appendLine()
        }
    }
    
    print(result)
}