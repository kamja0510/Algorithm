package templates

import kotlin.system.measureNanoTime

fun main(args : Array<String>){
    val array = Array<Int>(100){0}
    val list = List(100){0}
    val intArray = IntArray(100){0}
    val arrayList = MutableList(100){0} // ArrayList를 반환함.

    val arrayTime = measureNanoTime {
        array[77]
    }
    val listTime = measureNanoTime {
        list[77]
    }
    val intArrayTime = measureNanoTime {
        intArray[77]
    }
    val arrayListTime = measureNanoTime {
        arrayList[77]
    }

    println("array access time : $arrayTime")
    println("list access time : $listTime")
    println("intArray access time : $intArrayTime")
    println("arrayList access time : $arrayListTime")
}