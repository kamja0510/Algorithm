package templates

fun getGCD(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    } else {
        return getGCD(b, a % b)
    }
}

fun getLCM(a: Int, b: Int): Int {
    return (a * b) / getGCD(a, b)
}