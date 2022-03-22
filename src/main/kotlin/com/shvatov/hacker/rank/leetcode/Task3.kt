package com.shvatov.hacker.rank.leetcode

import kotlin.math.min

fun minCostClimbingStairs(cost: IntArray): Int {
    (cost.size - 3 downTo 0).forEach {
        cost[it] += min(cost[it + 1], cost[it + 2])
    }
    return min(cost[0], cost[1])
}

fun maxProfit(price: IntArray, start: Int, end: Int): Int {
    // If the stocks can't be bought
    if (end <= start) return 0

    // Initialise the profit
    var profit = 0

    // The day at which the stock
    // must be bought
    for (i in start until end) {

        // The day at which the
        // stock must be sold
        for (j in i + 1..end) {

            // If buying the stock at ith day and
            // selling it at jth day is profitable
            if (price[j] > price[i]) {

                // Update the current profit
                val curr_profit = (price[j] - price[i] + maxProfit(price, start, i - 1)
                        + maxProfit(price, j + 1, end))

                // Update the maximum profit so far
                profit = Math.max(profit, curr_profit)
            }
        }
    }
    return profit
}

fun main() {
    println()
}