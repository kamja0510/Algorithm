package baekjoon.class2

import java.io.*
import java.util.*

fun main(args : Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val numOfPeople = br.readLine().toInt()

    val rank = IntArray(numOfPeople){1}
    val datas = Array(numOfPeople){Pair(0,0)}
    for(i in 0 until numOfPeople){
        val st = StringTokenizer(br.readLine())
        datas[i] = Pair(st.nextToken().toInt(),st.nextToken().toInt())
    }
    for(i in 0 until numOfPeople-1){
        for(j in i+1 until numOfPeople){
            if(datas[i].first > datas[j].first && datas[i].second > datas[j].second){
                rank[j] += 1
            }else if(datas[i].first < datas[j].first && datas[i].second < datas[j].second){
                rank[i] += 1
            }
        }
    }
    rank.forEach{
        bw.write("$it")
        bw.write(" ")
    }
    bw.flush()
    bw.close()
}