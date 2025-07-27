package baekjoon.class2

import java.util.*

fun main(args : Array<String>){
    val participant = readln().toInt()
    val proposer = IntArray(6)
    var st = StringTokenizer(readln())
    val sb = StringBuffer()
    for(i in 0..5){
        proposer[i] = st.nextToken().toInt()
    }
    st = StringTokenizer(readln())
    val tShirts = st.nextToken().toInt()
    val pens = st.nextToken().toInt()

    var tShirtsBundle = 0
    var penBundle = 0
    var remainPen = 0

    proposer.forEach {
        tShirtsBundle += Math.ceil(it / tShirts.toDouble()).toInt()
    }
    penBundle = participant / pens
    remainPen = participant % pens

    sb.append(tShirtsBundle).append("\n").append(penBundle).append(" ").append(remainPen)
    print(sb)
}