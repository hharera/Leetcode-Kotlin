package com.harera.leetcode.leetcode213

class Solution {

    private var dp = Array(105) { -1 }

    fun rob(nums: IntArray): Int {
        if (nums.size < 3)
            return nums.max()!!

        val solution1 = nums.asList().subList(1, nums.size).let {
            solve(0, it.toIntArray())
        }
        dp = Array(105) { -1 }
        val solution2 = nums.asList().subList(0, nums.lastIndex).let {
            solve(0, it.toIntArray())
        }
        return maxOf(
            solution1,
            solution2
        )
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
    println(
        Solution().rob(
            intArrayOf(
                1, 2, 1, 1
            )
        )
    )
}