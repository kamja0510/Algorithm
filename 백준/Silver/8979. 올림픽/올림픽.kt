package baekjoon.problems8708

fun main(){
    val (numberOfCountry, targetCountryId) = readln().split(" ").map{ it.toInt() }

    val countries = ArrayList<Country>()

    repeat(numberOfCountry){
        val (id, gold, silver, bronze) = readln().split(" ").map{ it.toInt() }
        val country = Country(id, gold, silver, bronze)
        countries.add(country)
    }

    countries.sortWith(
        compareByDescending<Country>{ it.gold }
            .thenByDescending { it.silver }
            .thenByDescending { it.bronze }
    )

    val targetCountry = countries.find { it.id == targetCountryId }
    val targetCountryRank = countries.indexOfFirst {
        targetCountry!!.gold == it.gold && targetCountry.silver == it.silver && targetCountry.bronze == it.bronze
    } + 1

    println(targetCountryRank)
}

private data class Country(
    val id: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int,
)