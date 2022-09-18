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

fun readLineAndSplit() = readLine()!!.trimEnd().split(" ")

fun main(args: Array<String>) {
    val firstMultipleInput = readLineAndSplit()
    val n = firstMultipleInput[0].toInt()
    val m = firstMultipleInput[1].toInt()

    val workingArray = LongArray(n + 1) { 0 }
    repeat(m) {
        val (start, end, incrementValue) = readLineAndSplit()
            .map { it.toInt() }

        workingArray[start] += incrementValue.toLong()
        if (end + 1 < workingArray.size) {
            workingArray[end + 1] -= incrementValue.toLong()
        }
    }

    var maxValue = Long.MIN_VALUE
    var currentValue = 0L
    for (el in workingArray) {
        currentValue += el
        if (currentValue > maxValue) {
            maxValue = currentValue
        }
    }

    println(maxValue)
}

// 7496167325
// 7493235914