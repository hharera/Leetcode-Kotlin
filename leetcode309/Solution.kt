package com.harera.leetcode.leetcode309

import kotlin.math.max

class Solution {

    private val dp = Array(5005) { Array(5005) { -1 } }

    fun maxProfit(prices: IntArray): Int {
        return solve(0, prices, trans = 0, lastSell = -1)
    }

    private fun solve(idx: Int, prices: IntArray, trans: Int, lastSell: Int): Int {
        if (idx > prices.lastIndex)
            return 0

        if (dp[idx][trans] != -1)
            return dp[idx][trans]

        val answer = if (trans % 2 == 0) {
            val skip = solve(idx + 1, prices, trans, lastSell)
            if (idx - 1 == lastSell)
                skip
            else max(
                skip, -prices[idx] + solve(idx + 1, prices, trans + 1, lastSell)
            )
        } else {
            max(
                prices[idx] + solve(idx + 1, prices, trans + 1, idx),
                solve(idx + 1, prices, trans, lastSell)
            )
        }
        return answer.also {
            dp[idx][trans] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxProfit(intArrayOf(1,2,3,0,2)))
}
