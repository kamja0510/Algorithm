package programmers


var solutionNumberOfEmoticonPlus = 0
var solutionSalesAmount = 0

fun solution2(users: Array<IntArray>, emoticons: IntArray): IntArray {
    val numberOfEmoticons = emoticons.size
    val discounts: IntArray = IntArray(numberOfEmoticons){0}

    backtracking(
        depth = 0,
        numberOfEmoticons = numberOfEmoticons,
        discounts = discounts,
        users = users,
        emoticons = emoticons
    )

    var answer: IntArray = intArrayOf(solutionNumberOfEmoticonPlus, solutionSalesAmount)

    return answer
}

fun backtracking(
    depth: Int,
    numberOfEmoticons: Int,
    discounts: IntArray,
    users: Array<IntArray>,
    emoticons: IntArray
){
    if(depth == numberOfEmoticons){
        settle(
            discounts = discounts,
            users = users,
            emoticons = emoticons
        )
        return
    }
    for(i in 10 .. 40 step 10){
        discounts[depth] = i
        backtracking(
            depth = depth+1,
            numberOfEmoticons = numberOfEmoticons,
            discounts = discounts,
            users = users,
            emoticons = emoticons
        )
    }
}

fun settle(
    discounts: IntArray,
    users: Array<IntArray>,
    emoticons: IntArray
){
    var totalEmoticonPlus = 0
    var totalSalesAmount = 0
    users.forEach{ user ->
        var expenseAmount = 0
        for(i in 0 until emoticons.size){
            if(user[0] <= discounts[i]){
                expenseAmount += emoticons[i] / 100 * (100 - discounts[i])
            }
        }

        if(expenseAmount >= user[1])
            totalEmoticonPlus += 1
        else
            totalSalesAmount += expenseAmount
    }
    if(solutionNumberOfEmoticonPlus < totalEmoticonPlus){
        solutionNumberOfEmoticonPlus = totalEmoticonPlus
        solutionSalesAmount = totalSalesAmount
    }else if(solutionNumberOfEmoticonPlus == totalEmoticonPlus && solutionSalesAmount < totalSalesAmount)
        solutionSalesAmount = totalSalesAmount
}
