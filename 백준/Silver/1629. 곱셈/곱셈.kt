fun main(){
    val (base, exponent, divisor) = readln().split(" ").map{ it.toLong() }
    println(powDivide(base, exponent, divisor))
}

fun powDivide(
    base: Long,
    exponent: Long,
    divisor: Long,
): Long{
    if(exponent == 1L) return base % divisor
    val half = (powDivide(base, exponent / 2, divisor))
    val result = if(exponent % 2 == 0L){
        (half * half) % divisor
    }else{
        (((half * half )% divisor)* base) % divisor
    }
    return result
}