package com.shvatov.hacker.rank.leetcode


fun countBits(n: Int): IntArray {
    val ans = IntArray(n + 1)
    val powersOfTwo = mutableListOf(1)
    (0..n).forEach { current ->
        while (powersOfTwo.last() < current) {
            powersOfTwo.add(powersOfTwo.last() * 2)
        }

        var remainder = current
        var position = powersOfTwo.indices.last
        var ones = 0
        while (remainder >= 1) {
            if (remainder - powersOfTwo[position] >= 0) {
                remainder -= powersOfTwo[position]
                ones += 1
            }
            position--
        }

        ones += if (remainder == 1) 1 else 0
        ans[current] = ones
    }
    return ans
}

fun countBits2(n: Int): IntArray {
    val ans = IntArray(n + 1).apply {
        set(0, 0)
    }

    var nextPowerOfTwo = 2
    (1..n).forEach { current ->

    }
    return ans
}

fun countBits3(num: Int): IntArray {
    val dp = IntArray(num + 1)
    dp[0] = 0
    var nearest = 0
    for (k in 1..num) {
        if (k and k - 1 == 0) {
            dp[k] = 1
            nearest = k
        } else {
            dp[k] = dp[k - nearest] + dp[nearest]
        }
    }
    return dp
}

fun main() {
    println(countBits3(8).joinToString())
}