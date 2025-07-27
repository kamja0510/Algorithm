package baekjoon.class2

fun main(args : Array<String>){
    while(true){
        val number = readln()
        if(number == "0") break
        var isPalindrome = true
        var front = 0
        var back = number.length -1
        while(front <= back){
            if(number[front] != number[back]){
                isPalindrome = false
                break
            }
            front ++
            back --
        }
        if(isPalindrome) println("yes") else println("no")
    }
}