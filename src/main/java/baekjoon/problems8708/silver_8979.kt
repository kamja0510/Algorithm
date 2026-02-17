package baekjoon.problems8708

private data class Country(
    val id: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int,
)

fun main(){
    val (numberOfCountry, targetCountryId) = readln().split(" ").map{ it.toInt() }

    val countries = ArrayList<Country>()

    repeat(numberOfCountry){
        val (id, gold, silver, bronze) = readln().split(" ").map{ it.toInt() }
        val country = Country(id, gold, silver, bronze)
        countries.add(country)
    }

    val answer = makeRank2(
        targetCountryId = targetCountryId,
        countries = countries,
    )

    println(answer)
}

// 정렬을 이용한 순위 생성
// 23212KB, 156ms
private fun makeRank1(
    targetCountryId: Int,
    countries: ArrayList<Country>
): Int{
    countries.sortWith(
        compareByDescending<Country>{ it.gold }
            .thenByDescending { it.silver }
            .thenByDescending { it.bronze }
    )

    val targetCountry = countries.find { it.id == targetCountryId }
    val targetCountryRank = countries.indexOfFirst {
        targetCountry!!.gold == it.gold && targetCountry.silver == it.silver && targetCountry.bronze == it.bronze
    } + 1

    return targetCountryRank
}

// target 보다 등수높은 갯수 세기
// 23444KB 188ms
private fun makeRank2(
    targetCountryId: Int,
    countries: ArrayList<Country>
): Int{
    var numberOfHigherRank = 0
    val targetCountry = countries.find { it.id == targetCountryId } ?: Country(-1, -1, -1, -1)

    countries.forEach {
        if(it.gold > targetCountry.gold){
            numberOfHigherRank++
        }else if(it.gold == targetCountry.gold && it.silver > targetCountry.silver){
            numberOfHigherRank++
        }else if(it.gold == targetCountry.gold && it.silver == targetCountry.silver && it.bronze > targetCountry.bronze){
            numberOfHigherRank++
        }
    }

    return numberOfHigherRank + 1
}