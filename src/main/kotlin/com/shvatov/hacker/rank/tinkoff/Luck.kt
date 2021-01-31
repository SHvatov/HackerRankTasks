package com.shvatov.hacker.rank.tinkoff

import java.util.*

fun calculateMaximumLuck(luckPoints: Array<Int>): Int {
    assert(luckPoints.size == 4)
    var maximum = Integer.MIN_VALUE
    for (i in 1 until 4) {
        val otherPairLuck = (luckPoints.indices.toSet() - setOf(0, i))
            .fold(1) { acc, index ->
                acc * luckPoints[index]
            }
        val currentLuck = luckPoints[0] * luckPoints[i] + otherPairLuck
        maximum = if (currentLuck > maximum) currentLuck else maximum
    }
    return maximum
}

fun main() {
    val scan = Scanner(System.`in`)
    val luckPoints = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val result = calculateMaximumLuck(luckPoints)
    println(result)
}
