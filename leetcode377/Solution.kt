package com.harera.leetcode.leetcode377


class Solution {

    private val dp = IntArray(1005) { -1 }

    fun combinationSum4(nums: IntArray, target: Int): Int {
        return solve(nums, remaining = target)
    }

    private fun solve(nums: IntArray, remaining: Int): Int {
        if (remaining == 0)
            return 1

        if (dp[remaining] != -1)
            return dp[remaining]

        var ans = 0
        for (num in nums) {
            if (num <= remaining) {
                ans += solve(nums, remaining - num)
            }
        }

        return ans.also {
            dp[remaining] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.combinationSum4(intArrayOf(9), 3))
}
