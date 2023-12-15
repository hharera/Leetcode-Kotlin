package com.harera.leetcode.leetcode188

import kotlin.math.max

class Solution {

    private val dp = Array(1001) { Array(202) { -1 } }

    fun maxProfit(k: Int, prices: IntArray): Int {
        return solve(idx = 0, prices, k, trans = 0, lastBuy = 1000)
    }

    private fun solve(idx: Int, prices: IntArray, k: Int, trans: Int, lastBuy: Int): Int {
        if (idx > prices.lastIndex)
            return 0

        if (k < 1)
            return 0

        if (dp[idx][trans] != -1)
            return dp[idx][trans]

        val answer = if (trans % 2 == 0) {
            max(
                -prices[idx] + solve(idx + 1, prices, k, trans + 1, lastBuy = idx),
                solve(idx + 1, prices, k, trans, lastBuy)
            )
        } else {
            max(
                prices[idx] + solve(idx + 1, prices, k - 1, trans + 1, lastBuy = 1000),
                solve(idx + 1, prices, k, trans, lastBuy)
            )
        }
        return answer.also {
            dp[idx][trans] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxProfit(4, intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9)))
}