package baekjoon.barkingdog.stack

// 오른쪽 사람이 왼쪽 사람을 볼 수 있냐를 기준으로 풀이

private data class HeightBlock(val height: Int, val count: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var totalPairs = 0L
    val stack = ArrayDeque<HeightBlock>()

    repeat(n) {
        val currentHeight = br.readLine().toInt()

        while (stack.isNotEmpty() && stack.last().height < currentHeight) {
            totalPairs += stack.last().count.toLong()
            stack.removeLast()
        }

        if (stack.isEmpty()) {
            stack.addLast(HeightBlock(height = currentHeight, count = 1))
        } else {
            val (topHeight, topCount) = stack.last()

            if (topHeight == currentHeight) {
                stack.removeLast()
                totalPairs += topCount.toLong()
                // 볼 수 있는 블럭이 더 있는 경우
                if (stack.isNotEmpty()) totalPairs += 1L
                stack.addLast(HeightBlock(height = currentHeight, count = topCount+1))
            } else {
                totalPairs += 1L
                stack.addLast(HeightBlock(height = currentHeight, count = 1))
            }
        }
    }

    println(totalPairs)
}
// 스택에는 왼쪽에서 아직 오른쪽 큰(또는 같은 높이의) 사람을 만나지 못한 사람들의 정보를 유지한다.
// 새로운 사람이 들어오면 이 사람보다 작은 높이들은 이 이후에 들어오는 사람 중 보이는 사람이 없으므로 count를 더하고 pop
// 새로운 사람이 마지막 블록 높이와 같다면 그 블록의 모든 사람은 지금 들어온 사람을 볼 수 있으므로 count 만큼 더한다.
// 그러고 remove 해서 합치는데 이때 이 전에 더 큰 블록이 존재한다면 쌍이 하나 더 추가