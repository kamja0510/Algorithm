package programmers

class DiscountEvent {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        var canDiscount = false
        val wantSize = want.size
        var needDays = 0
        val wantCount = mutableMapOf<String, Int>().apply{
            (0 until wantSize).forEach{
                put(want[it], number[it])
                needDays += number[it]
            }
        }

        discount.forEachIndexed{ index, item ->
            val startIndex = index - needDays
            if(wantCount.containsKey(item)){
                wantCount[item] = wantCount[item]!! - 1
            }
            if(startIndex >= 0 && wantCount.containsKey(discount[startIndex])){
                wantCount[discount[startIndex]] = wantCount[discount[startIndex]]!! + 1
            }
            canDiscount = wantCount.check()
            if(canDiscount) answer++
        }

        return answer
    }

    fun MutableMap<String, Int>.check(): Boolean = this.values.all { it <= 0 }
}

fun main(){
    val solution = DiscountEvent()
    val want = "[\"banana\", \"apple\", \"rice\", \"pork\", \"pot\"]".toStringArray()
    val number = "[3, 2, 2, 2, 1]".toIntArray()
    val discount = "[\"chicken\", \"apple\", \"apple\", \"banana\", \"rice\", \"apple\", \"pork\", \"banana\", \"pork\", \"rice\", \"pot\", \"banana\", \"apple\", \"banana\"]".toStringArray()
    print(solution.solution(want, number, discount))
}