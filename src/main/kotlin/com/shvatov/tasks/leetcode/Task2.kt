package com.shvatov.tasks.leetcode


fun tribonacci(n: Int): Int {
    val precalculatedFib = IntArray(size = n + 1, init = { -1 }).apply {
        set(0, 0)
        if (n >= 1) {
            set(1, 1)
        }
        if (n >= 2) {
            set(2, 1)
        }
    }

    @Suppress("FunctionName")
    fun _tribonacci(k: Int): Int {
        val value = precalculatedFib[k]
        if (value < 0) {
            precalculatedFib[k] = _tribonacci(k - 1) + _tribonacci(k - 2) + _tribonacci(k - 3)
        }
        return precalculatedFib[k]
    }

    return _tribonacci(n)
}

fun main() {
    println(tribonacci(25))
}