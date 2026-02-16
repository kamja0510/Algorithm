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