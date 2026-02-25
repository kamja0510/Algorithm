fun main(){
    val switchCount = readln().toInt()
    val statesOfSwitch = readln().split(" ").map{ it.toInt() }.toMutableList()
    val studentsCount = readln().toInt()
    repeat(studentsCount){
        val (gender, number) = readln().split(" ").map{ it.toInt() }
        when(gender){
            1 -> {
                var index = number - 1
                while(index < switchCount){
                    statesOfSwitch[index] = statesOfSwitch[index] xor 1
                    index += number
                }
            }
            2 -> {
                var start = number - 2
                var end = number
                statesOfSwitch[number - 1] = statesOfSwitch[number - 1] xor 1
                while(start >= 0 && end < switchCount){
                    if(statesOfSwitch[start] != statesOfSwitch[end]) break
                    statesOfSwitch[start] = statesOfSwitch[start] xor 1
                    statesOfSwitch[end] = statesOfSwitch[end] xor 1
                    start--
                    end++
                }
            }
        }
    }
    val answer = buildString {
        statesOfSwitch.forEachIndexed { index, i ->
            append(i)
            if((index + 1) % 20 == 0)appendLine() else append(" ")
        }
    }
    println(answer)
}