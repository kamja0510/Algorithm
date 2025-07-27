package programmers

fun main(args: Array<String>){
    solution(4, intArrayOf(4,4,4,4))
}

fun solution(N: Int, stages: IntArray): IntArray {  // 사용자 수 범위 : 1~200000
    val countCurrentStage = mutableMapOf<Int, Double>()
    var numberOfUsers = stages.size

    for(stage in stages){
        if(countCurrentStage.containsKey(stage)){
            countCurrentStage[stage] = countCurrentStage[stage]!! + 1
        }else{
            countCurrentStage[stage] = 1.0
        }
    }

    for(i in 1 ..N){
        if(numberOfUsers==0) countCurrentStage[i] = 0.0
        else{
            val currentStage = countCurrentStage[i]
            countCurrentStage[i] = (countCurrentStage[i]?:0).toDouble() / numberOfUsers
            numberOfUsers -= (currentStage?:0).toInt()
        }
    }
    countCurrentStage.remove(N+1)

    val rateOfFailure = countCurrentStage.entries.sortedWith(compareByDescending<Map.Entry<Int,Double>> { it.value  }.thenBy { it.key })

    print(countCurrentStage)



    var answer = IntArray(N){rateOfFailure[it].key}

    return answer
}