package baekjoon.barkingdog.array

fun main(){
    val roomNumber = readln().toInt()
    val numbers = IntArray(10)

    roomNumber.toString().forEach {
        numbers[it.digitToInt()]++
    }
    // 6과 9를 제외한 숫자들의 최대 개수
    var maxCount = 0
    for (i in 0..9) {
        if (i != 6 && i != 9) {
            maxCount = maxOf(maxCount, numbers[i])
        }
    }

    val sixOrNine = (numbers[6]+numbers[9]+1)/2
    print(maxOf(maxCount, sixOrNine))
}