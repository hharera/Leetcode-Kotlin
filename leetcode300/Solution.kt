package com.harera.leetcode.leetcode300

import kotlin.math.max

class Solution {

    private val dp = Array<Int>(2500) { -1 }

    fun lengthOfLIS(nums: IntArray): Int {
        return solve(nums, 0, Int.MIN_VALUE)
    }

    private fun solve(nums: IntArray, idx: Int, prev: Int): Int {
        if (idx > nums.lastIndex)
            return 0

        if (dp[idx] != -1)
            return dp[idx]

        val leave = solve(nums, idx + 1, prev)
        if (nums[idx] <= prev)
            return leave

        val pick = solve(nums, idx + 1, nums[idx])
        return max(pick + 1, leave).also {
            dp[idx] = it
        }
    }
}

fun main() {
    // 5 test cases
    val solution = Solution()
    println(solution.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
}
