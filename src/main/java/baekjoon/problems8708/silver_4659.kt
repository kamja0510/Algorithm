package baekjoon.problems8708

private data class ConsecutiveInformation(
    val charType: CharType?,
    val consecutiveCount: Int,
)

private enum class CharType{
    CONSONANT,
    VOWEL
}

private val vowel = setOf('a','e','i','o','u')

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
// 19512KB, 124ms
private fun validatePassword(
    password: String,
): String{

    var hasVowel = false
    var previousAlphabet = '?'
    var currentConsecutiveInformation = ConsecutiveInformation(
        charType = null,
        consecutiveCount = 0
    )

    password.forEach{ char ->
        val currentCharType = char.checkCharType()

        // 연속 알파벳 체크
        if(char == previousAlphabet && char != 'e' && char != 'o'){
            return "<$password> is not acceptable."
        }

        // 연속 자음, 모음 체크
        if(currentConsecutiveInformation.consecutiveCount == 2 && currentConsecutiveInformation.charType == currentCharType){
            return "<$password> is not acceptable."
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

        // 모음 가지는지 체크
        if(currentCharType == CharType.VOWEL) hasVowel = true

        previousAlphabet = char
    }


    return if(hasVowel) "<$password> is acceptable." else "<$password> is not acceptable."
}

private fun Char.checkCharType(): CharType{
    return if(vowel.contains(this)) CharType.VOWEL else CharType.CONSONANT
}