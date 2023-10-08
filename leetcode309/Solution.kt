package com.harera.leetcode.leetcode309

import kotlin.math.max

class Solution {

    private val dp = Array(5005) { Array(5005) { -1 } }

    fun maxProfit(prices: IntArray): Int {
        return solve(prices, 0, haveBought = false, lastBuy = 0, lastSell = null)
    }

    private fun solve(prices: IntArray, idx: Int = 0, haveBought: Boolean, lastSell: Int?, lastBuy: Int): Int {
        if (idx > prices.lastIndex) {
            return 0
        }

        if (dp[idx][lastSell ?: 0] != -1)
            return dp[idx][lastSell ?: 0]

        var answer = 0
        if (haveBought) {
            val solution = solve(prices, idx + 1, haveBought = false, lastSell = idx, lastBuy = lastBuy)
            answer = max(prices[idx] - prices[lastBuy] + solution, answer)
        } else if (idx - (lastSell ?: -2) > 1) {
            val solution = solve(prices, idx + 1, haveBought = true, lastSell = lastSell, lastBuy = idx)
            answer = max(solution, answer)
        }
        val solution = solve(prices, idx + 1, haveBought, lastSell, lastBuy)
        answer = max(answer, solution)

        return answer.also {
            dp[idx][(lastSell ?: 0)] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxProfit(intArrayOf(1, 2, 4)))
}
