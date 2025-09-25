package baekjoon.barkingdog.backtracking

fun main(){
    val size = readln().toInt()
    val isUsedColumn = BooleanArray(size)
    val isUsedRowPlusColumn = BooleanArray(2*size - 1)
    val isUsedRowMinusColumn = BooleanArray(2*size - 1)
    println(placeQueen(isUsedColumn, isUsedRowPlusColumn, isUsedRowMinusColumn, 0))
}

fun placeQueen(
    isUsedColumn : BooleanArray,
    isUsedRowPlusColumn : BooleanArray,
    isUsedRowMinusColumn : BooleanArray,
    step: Int,
): Int{
    if(step == isUsedColumn.size){
        return 1
    }

    var solutionsFound = 0
    for(i in 0..<isUsedColumn.size){
        if(isUsedColumn[i] || isUsedRowPlusColumn[step + i] || isUsedRowMinusColumn[step - i + isUsedColumn.size - 1]) continue
        isUsedColumn[i] = true
        isUsedRowMinusColumn[step - i + isUsedColumn.size - 1] = true
        isUsedRowPlusColumn[step + i] = true
        solutionsFound += placeQueen(isUsedColumn, isUsedRowPlusColumn, isUsedRowMinusColumn, step+1)
        isUsedColumn[i] = false
        isUsedRowMinusColumn[step - i + isUsedColumn.size - 1] = false
        isUsedRowPlusColumn[step + i] = false
    }
    return solutionsFound
}