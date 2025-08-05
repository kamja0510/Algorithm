fun main() {
    val n = readln().toInt()

    val result = buildString {
        for (i in 1..n) {
            repeat(n - i) { append(' ') }
            repeat(i) { append('*') }
            append('\n')
        }
    }

    print(result)
}