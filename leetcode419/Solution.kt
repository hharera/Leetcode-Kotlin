package com.harera.leetcode.leetcode419

import kotlin.math.max

private operator fun <T> Array<T>.get(haveBought: Boolean): T {
    if (haveBought)
        return get(1)
    return get(0)
}


private operator fun <T> Array<T>.set(b: Boolean, value: T) {
    if (b)
        set(1, value)
    set(0, value)
}

class Solution {

    private val dp = Array<Array<Int>>(100005) { Array(2) { -1 } }
    fun maxProfit(prices: IntArray): Int {
        return solve(prices, emptyList(), 0)
    }

    private fun solve(prices: IntArray, items: List<Int>, idx: Int = 0): Int {
        if (idx > prices.lastIndex)
            return 0

        if (items.size == 4)
            return 0

        if (dp[idx][items.size % 2 == 1] != -1)
            return dp[idx][items.size % 2 == 1]

        var answer = 0
        if (items.size % 2 == 1) {
            val item = items.last()
            val solution = solve(prices, items.plus(prices[idx]), idx + 1)
            answer = max(prices[idx] - item + solution, answer)
        } else {
            val solution = solve(prices, items.plus(prices[idx]), idx + 1)
            answer = max(solution, answer)
        }

        val solution = solve(prices, items, idx + 1)
        answer = max(solution, answer)

        return answer.also {
            dp[idx][items.size % 2 == 1] = it
        }
    }
}


fun main() {
    val solution = Solution()
    println(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}