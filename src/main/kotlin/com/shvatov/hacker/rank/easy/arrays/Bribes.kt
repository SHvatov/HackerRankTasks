package com.shvatov.hacker.rank.easy.arrays

fun isSorted(q: Array<Int>): Boolean {
    (0 until q.size - 1).forEach {
        if (q[it] > q[it + 1]) return false
    }
    return true
}

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */
fun minimumBribes(q: Array<Int>) {
    // Write your code here

    val swaps = mutableMapOf<Int, Int>()
    while (!isSorted(q)) {
        (0 until q.size - 1).forEach {
            if (q[it] > q[it + 1]) {
                swaps.putIfAbsent(q[it], 0)
                swaps[q[it]] = swaps.getValue(q[it]) + 1

                val temp = q[it]
                q[it] = q[it + 1]
                q[it + 1] = temp
            }
        }
    }

    val isTooChaotic = swaps.values.any { it >= 3 }
    if (isTooChaotic) {
        println("Too chaotic")
        return
    } else {
        println(swaps.values.sum())
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        readLine()
        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        minimumBribes(q)
    }
}
