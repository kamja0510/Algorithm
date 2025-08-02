package baekjoon.barkingdog.basicCode

fun main() {
    val n = 5
    val num = Array(n) { 0 }
    var sum = 0
    repeat(n) {
        num[it] = readln().toInt()
        sum += num[it]
    }
    insertionSort(num)
    print("${sum / n}\n${num[2]}")
}

fun insertionSort(list: Array<Int>) {
    for (i in 1 until list.size) {
        val key = list[i]
        var j = i - 1

        // 왼쪽에 있는 값들과 비교하면서 자리를 찾는다
        while (j >= 0 && list[j] > key) {
            list[j + 1] = list[j]
            j--
        }

        // key 값을 올바른 위치에 삽입
        list[j + 1] = key
    }
}