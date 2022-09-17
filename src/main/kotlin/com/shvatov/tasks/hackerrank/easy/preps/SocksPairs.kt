package com.shvatov.tasks.hackerrank.easy.preps

fun sockMerchant(ar: Array<Int>): Int {
    return ar.groupBy { it }
        .mapValues { it.value.size / 2 }
        .values
        .sum()
}

fun main() {
    print(sockMerchant(arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)))
}