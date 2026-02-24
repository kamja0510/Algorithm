fun main(){
    val (entryCount, kindOfGame) = readln().split(" ")

    val names = mutableSetOf<String>()

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