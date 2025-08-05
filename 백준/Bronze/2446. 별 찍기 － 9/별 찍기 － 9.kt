package baekjoon.barkingdog.basicCode

fun main(){
    val n = readln().toInt()
    
    val result = buildString {
        for(i in n downTo 1){
            repeat(n-i){ append(' ')}
            repeat(2*i - 1){ append('*') }
            appendLine()
        }
        for(i in 2..n){
            repeat(n-i){ append(' ')}
            repeat(2*i - 1){ append('*') }
            appendLine()
        }
    }
    
    print(result)
}