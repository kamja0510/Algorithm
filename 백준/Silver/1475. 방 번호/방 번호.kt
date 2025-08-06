package baekjoon.barkingdog.array

fun main(){
    val roomNumber = readln().toInt()
    val numbers = IntArray(10)

    roomNumber.toString().forEach {
        numbers[it.digitToInt()]++
    }
    val maxCount = numbers.filterIndexed { index, value ->
        index != 6 && index != 9
    }.maxOrNull()
    val sixOrNine = (numbers[6]+numbers[9]+1)/2
    val result = if( maxCount!! > sixOrNine) maxCount else sixOrNine
    print(result)
}