package com.harera.leetcode.leetcode322

class Solution {

    private val dp = Array<Int>(10005) { -1 }

    fun coinChange(coins: IntArray, amount: Int): Int {
        val min = dp(coins = coins, reminding = amount)
        if (min > 10000)
            return -1
        return min
    }

    private fun dp(coins: IntArray, reminding: Int): Int {
        if (reminding == 0)
            return 0

        if (dp[reminding] != -1)
            return dp[reminding]

        var ans = 10005
        for (coin in coins) {
            if (reminding >= coin)
                ans = minOf(dp(coins, reminding - coin) + 1, ans)
        }
        dp[reminding] = ans
        return ans
    }
}

fun main() {
    println(Solution().coinChange(intArrayOf(3, 7, 405, 436), 8839))
    println(Solution().coinChange(intArrayOf(2), 3))
}