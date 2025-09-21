package baekjoon.barkingdog.bfs

import java.util.StringTokenizer

fun main(){
    val br = System.`in`.bufferedReader()
    val testCases = br.readLine().toInt()
    repeat(testCases){
        val students = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        val selection = IntArray(students){
            st.nextToken().toInt() -1
        }
        val finished = BooleanArray(students)
        val visited = IntArray(students)
        var selectedStudents = 0
        for(i in 0..<students) {
            if(finished[i]) continue
            var current = i

            while(visited[current] == 0 && !finished[current]){
                visited[current] = i + 1
                current = selection[current]
            }

            if(visited[current] == i + 1 && !finished[current]){
                var count = 1
                var next = selection[current]
                while(next != current){
                    next = selection[next]
                    count++
                }
                selectedStudents += count
            }

            current = i
            while(!finished[current]){
                finished[current] = true
                current = selection[current]
            }
        }
        println(students - selectedStudents)
    }
}