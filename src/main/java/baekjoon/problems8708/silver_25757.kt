package baekjoon.problems8708

/**
 * 윷놀이(Y, 2), 같은 그림 찾기(F, 3), 원카드(O, 4)
 * 중복해서 할 수 없다.(Set)
 * 인원이 다 차야 게임을 할 수 있다.(나머지를 버린 몫)
 */

// 28088 KB, 276ms -> MutableSet
// 27248KB, 292ms -> HashSet
fun main(){
    val (entryCount, kindOfGame) = readln().split(" ")

    val names = hashSetOf<String>()

    repeat(entryCount.toInt()){
        names.add(readln())
    }
    val numberOfPeople = names.size

    val answer = when(kindOfGame){
        "Y" -> numberOfPeople / 1
        "F" -> numberOfPeople / 2
        "O" -> numberOfPeople / 3
        else -> -1
    }

    println(answer)
}