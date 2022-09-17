package com.shvatov.tasks.hackerrank.easy.common

import java.util.*

fun minimumDistances(array: Array<Int>): Int {
    var minimumDistance = Int.MAX_VALUE
    val positionMap = mutableMapOf<Int, Int>()
    for ((index, elem) in array.withIndex()) {
        if (positionMap.containsKey(elem)) {
            val distance = index - positionMap.getValue(elem)
            if (distance <= minimumDistance) {
                minimumDistance = distance
            }
        }

        positionMap[elem] = index
    }
    return if (minimumDistance == Int.MAX_VALUE) -1 else minimumDistance
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()
    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumDistances(a)
    println(result)
}
