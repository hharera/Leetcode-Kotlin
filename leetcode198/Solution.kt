package com.harera.leetcode.leetcode198

class Solution {

    private val dp = Array<Int>(105) { -1 }

    fun rob(nums: IntArray): Int {
        return solve(0, nums)
    }

    private fun solve(idx: Int, nums: IntArray): Int {
        if (idx > nums.lastIndex) {
            return 0
        }

        if (dp[idx] != -1)
            return dp[idx]

        val answer = maxOf(
            nums[idx] + solve(idx + 2, nums),
            solve(idx + 1, nums)
        )

        return answer.also {
            dp[idx] = answer
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.rob(intArrayOf(1, 2, 3, 1)))
}