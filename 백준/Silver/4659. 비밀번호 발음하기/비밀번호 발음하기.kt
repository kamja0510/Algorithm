package baekjoon.problems8708

private data class ConsecutiveInformation(
    val charType: CharType?,
    val consecutiveCount: Int,
)

private enum class CharType{
    Consonant,
    Vowel
}

fun main(){
    while(true){
        val password = readln()
        if(password == "end") break
        println(validatePassword(password))
    }
}

/**
1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 */
private fun validatePassword(
    password: String,
): String{
    var hasVowel = false
    var hasNotTripleConsecutiveCharType = true
    var hasNotDoubleConsecutiveAlphabet = true

    var previousAlphabet = '?'
    var currentConsecutiveInformation = ConsecutiveInformation(
        charType = null,
        consecutiveCount = 0
    )

    password.forEachIndexed{ index, char ->
        val currentCharType = char.checkCharType()
        if(char == previousAlphabet && char != 'e' && char != 'o'){
            hasNotDoubleConsecutiveAlphabet = false
            // 여기에서 그냥 실패
        }

        if(currentConsecutiveInformation.consecutiveCount == 2 && currentConsecutiveInformation.charType == currentCharType){
            hasNotTripleConsecutiveCharType = false
            // 여기에서 그냥 실패
        }else if(currentConsecutiveInformation.charType == currentCharType){
            currentConsecutiveInformation = ConsecutiveInformation(
                charType = currentCharType,
                consecutiveCount = currentConsecutiveInformation.consecutiveCount+1,
            )
        }else {
            currentConsecutiveInformation = ConsecutiveInformation(
                charType = currentCharType,
                consecutiveCount = 1,
            )
        }

        if(char.checkCharType() == CharType.Vowel) hasVowel = true

        previousAlphabet = char
    }


    return if(hasVowel && hasNotDoubleConsecutiveAlphabet && hasNotTripleConsecutiveCharType) "<$password> is acceptable." else "<$password> is not acceptable."
}

private fun Char.checkCharType(): CharType{
    val vowel = setOf('a','e','i','o','u')

    return if(vowel.contains(this)) CharType.Vowel else CharType.Consonant
}