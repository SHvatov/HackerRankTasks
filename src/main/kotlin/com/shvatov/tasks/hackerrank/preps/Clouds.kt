package com.shvatov.tasks.hackerrank.preps

import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var (pathSize, currentCloud) = 0 to c.size - 1
    while (currentCloud != 0) {
        currentCloud -= when {
            currentCloud - 2 >= 0 && c[currentCloud - 2] == 0 -> 2
            currentCloud - 1 >= 0 && c[currentCloud - 1] == 0 -> 1
            else -> throw IllegalArgumentException("Can't find the minimum path!")
        }
        pathSize++
    }
    return pathSize
}

fun main() {
    val scan = Scanner(System.`in`)
    scan.nextLine().trim().toInt()
    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val result = jumpingOnClouds(c)
    println(result)
}
