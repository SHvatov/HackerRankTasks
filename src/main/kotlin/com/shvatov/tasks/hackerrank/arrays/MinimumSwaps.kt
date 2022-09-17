package com.shvatov.tasks.hackerrank.arrays

import java.util.*

private const val MAX_ARRAY_SIZE = 100000

fun Array<Int>.isSorted(): Boolean {
    (0 until size - 1).forEach {
        if (get(it) > get(it + 1)) {
            return false
        }
    }
    return true
}

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    val elementPositions = arrayOfNulls<Int>(MAX_ARRAY_SIZE + 1)
    for ((position, element) in arr.withIndex()) {
        elementPositions[element] = position
    }

    var swaps = 0
    var arrayPosition = 0

    while (!arr.isSorted()) {
        (0..MAX_ARRAY_SIZE).forEach { element ->
            val currentPosition = elementPositions[element]
            if (currentPosition != null) {
                if (arrayPosition != currentPosition) {
                    val currentElement = arr[arrayPosition]
                    arr[arrayPosition] = element
                    arr[currentPosition] = currentElement

                    elementPositions[element] = arrayPosition
                    elementPositions[currentElement] = currentPosition

                    swaps++
                }
                arrayPosition++
            }
        }
    }
    return swaps
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
