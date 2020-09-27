package com.shvatov.hacker.rank.easy

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */
fun countingValleys(path: String): Int {
    var (valleys, depth) = 0 to 0
    path.toCharArray()
        .map { if (it == 'U') 1 else -1 }
        .forEach {
            if (depth < 0 && depth + it == 0) {
                valleys += 1
            }
            depth += it
        }
    return valleys
}

fun main() {
    readLine()!!.trim().toInt()
    val path = readLine()!!
    val result = countingValleys(path)
    println(result)
}
