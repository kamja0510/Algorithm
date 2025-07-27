package baekjoon.class2

import java.io.*

fun main(args : Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var answer = 0
    for(i in 0 until 3){
        val waitForNumber = br.readLine().toIntOrNull()
        if(waitForNumber != null && answer == 0){
            answer += waitForNumber + (3 - i)
        }
    }
    if(answer % 15 == 0){
        print("FizzBuzz")
    }else if(answer % 5 == 0){
        print("Buzz")
    }else if(answer % 3 ==0){
        print("Fizz")
    }else print(answer)
}