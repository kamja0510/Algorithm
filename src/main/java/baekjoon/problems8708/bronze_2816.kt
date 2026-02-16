package baekjoon.problems8708

fun main(){
    val numberOfChannels = readln().toInt()
    var indexOfKBS1 = -1
    var indexOfKBS2 = -1
    val channelList = List<String>(numberOfChannels){ index ->
        val channel = readln()
        if(channel == "KBS1") indexOfKBS1 = index
        else if(channel == "KBS2") indexOfKBS2 = index
        channel
    }
    remoteTV(
        indexOfKBS1 = indexOfKBS1,
        indexOfKBS2 = indexOfKBS2,
    )
}

private fun remoteTV(
    indexOfKBS1: Int,
    indexOfKBS2: Int,
){
    // 단순 생각 : 화살표를 내리면서 KBS1을 먼저 첫번째로 올리고, 또 내려가서 KBS2를 두번째로 내리기.

    // 이때, 1,4,1 이 연속으로 나오는 동작은 3으로 대체가 가능하다. 3번 자체가 1,4,1을 연속으로 시행하는 동작이기 때문.
    // 만약, KBS2에서 1,4 동작으로 끝난다면 이것또한 3으로 대체가 가능하다. 왜냐하면 화살표를 내리는 동작이 필요없기 때문.
    // 3으로 화살표를 내리는 다가 다음이 KBS1이라면 1로 화살표를 내리는 것이 효율적이다. 왜냐하면 KBS2가 먼저 있을 경우 위치를 하나 올려주기 때문에
    // KBS2를 위로 올릴때 과정이 한단계 생략된다.

    val sb = StringBuilder()
    if(indexOfKBS1 < indexOfKBS2){
        repeat(indexOfKBS1){
            sb.append(1)
        }
        repeat(indexOfKBS1){
            sb.append(4)
        }
        repeat(indexOfKBS2){
            sb.append(1)
        }
        repeat(indexOfKBS2-1){
            sb.append(4)
        }
    }else{
        repeat(indexOfKBS1){
            sb.append(1)
        }
        repeat(indexOfKBS1){
            sb.append(4)
        }
        repeat(indexOfKBS2+1){
            sb.append(1)
        }
        repeat(indexOfKBS2){
            sb.append(4)
        }
    }
    println(sb.toString())
}