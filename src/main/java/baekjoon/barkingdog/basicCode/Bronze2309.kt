package baekjoon.barkingdog.basicCode

fun main() {
    var sum = 0
    val length = IntArray(9){
        val num = readln().toInt()
        sum += num
        num
    }.insertionSort()
    val findPair = sum - 100
    var start = 0
    var end = length.size - 1
    while(start< end && length[start] + length[end] != findPair){
        when{
            length[start] + length[end] < findPair -> start++
            length[start] + length[end] > findPair -> end--
        }
    }
    print(
        buildString {
            length.forEachIndexed{ index, value ->
                if(index != start && index != end){
                    append("$value\n")
                }
            }
        }
    )
}

private fun IntArray.insertionSort() : IntArray{
    for (i in 1 ..< this.size){
        val key = this[i]
        var j = i -1
        while(j >= 0 && this[j] > key){
            this[j+1] = this[j]
            j--
        }
        this[j+1] = key
    }
    return this
}
// 12352kb 88ms