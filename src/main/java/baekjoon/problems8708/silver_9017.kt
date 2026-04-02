package baekjoon.problems8708

// 26160KB, 240ms
fun main(){
    val testCaseCount = readln().toInt()

    repeat(testCaseCount){
        val playerCount = readln().toInt()
        val rank = readln().split(" ").map{ it.toInt() }
        val exceptedTeam = rank.groupingBy { it }.eachCount().filter { it.value < 6 }.keys
        val filteredRank = mutableListOf<Int>()
        rank.forEach{
            if(!exceptedTeam.contains(it)) filteredRank.add(it)
        }
        val teamRank = mutableMapOf<Int, MutableList<Int>>()
        filteredRank.forEachIndexed { index, teamNumber ->
            if(teamRank.keys.contains(teamNumber)){
                teamRank[teamNumber]?.add(index+1)
            }else{
                teamRank[teamNumber] = mutableListOf(index+1)
            }
        }
        val filteredTeamRank = teamRank.filter { it.value.size >= 6 }

        var answer = 0
        var lowestScore = Int.MAX_VALUE
        var fifthPlayersScore = 0
        teamRank.keys.forEach {
            val currentTeamsScore = filteredTeamRank[it]?.take(4)?.sum() ?: 0
            val currentTeamsFifthPlayersScore = filteredTeamRank[it]?.get(4) ?: 0
            if(currentTeamsScore < lowestScore){
                answer = it
                lowestScore = currentTeamsScore
                fifthPlayersScore = currentTeamsFifthPlayersScore
            }else if(currentTeamsScore == lowestScore){
                if(fifthPlayersScore > currentTeamsFifthPlayersScore) {
                    answer = it
                    fifthPlayersScore = currentTeamsFifthPlayersScore
                }
            }
        }
        println(answer)
    }
}