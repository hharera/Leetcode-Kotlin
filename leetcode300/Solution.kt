package com.harera.leetcode.leetcode300

import kotlin.math.max

class Solution {

    private val dp = Array(2500) { Array(2505) { -1 } }

    fun lengthOfLIS(nums: IntArray): Int {
        return solve(nums, 0, Int.MIN_VALUE)
    }

    private fun solve(nums: IntArray, idx: Int, max: Int, lastIdx: Int = 2504): Int {
        if (idx > nums.lastIndex)
            return 0

        if (dp[idx][lastIdx] != -1)
            return dp[idx][lastIdx]

        val leave = solve(nums, idx + 1, max, lastIdx)
        if (nums[idx] <= max)
            return leave

        val pick = 1 + solve(nums, idx + 1, nums[idx], idx)
        return max(pick, leave).also {
            dp[idx][lastIdx] = it
        }
    }
}

fun main() {
    // 5 test cases
    val solution = Solution()
    println(solution.lengthOfLIS(intArrayOf(7,7,7)))
}
