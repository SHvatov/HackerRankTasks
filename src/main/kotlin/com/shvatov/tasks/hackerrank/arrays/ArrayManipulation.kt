package com.shvatov.tasks.hackerrank.arrays

import java.util.*

val Array<Long>.start: Long
    get() = get(0) - 1

val Array<Long>.end: Long
    get() = get(1) - 1

val Array<Long>.incrementValue: Long
    get() = get(2)

fun arrayManipulation(n: Int, queries: Array<Array<Long>>): Long {
    val sortedQueries = LinkedList(queries.sortedBy { it[0] })
    val workingArray = LongArray(n) { 0L }

    var maxArrayValue = Long.MIN_VALUE
    val deprecatedQueries = mutableSetOf<Int>()
    workingArray.indices.forEach { index ->
        sortedQueries.withIndex().forEach { (queryIndex, query) ->
            if (!deprecatedQueries.contains(queryIndex)) {
                if (index >= query.start) {
                    workingArray[index] += query.incrementValue
                }

                if (index >= query.end) {
                    deprecatedQueries.add(queryIndex)
                }
            }
        }

        if (workingArray[index] > maxArrayValue) {
            maxArrayValue = workingArray[index]
        }
    }
    return maxArrayValue
}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()

    val m = firstMultipleInput[1].toInt()

    val queries = Array(m) { Array(3) { 0L } }

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}

// 7496167325
// 8209183117