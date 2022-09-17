package com.shvatov.tasks.hackerrank.easy.preps

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    val wholeStrRepeatNum = n / s.length
    val remainingSubStrLen = (n - wholeStrRepeatNum * s.length).toInt()
    val subStrRepeatNum = if (remainingSubStrLen != 0) s.substring(0, remainingSubStrLen).count { it == 'a' } else 0
    return wholeStrRepeatNum * s.count { it == 'a' } + subStrRepeatNum
}

fun main() {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine()
    val n = scan.nextLine().trim().toLong()
    val result = repeatedString(s, n)
    println(result)
}
