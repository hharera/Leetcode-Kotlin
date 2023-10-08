package com.harera.leetcode.leetcode312

class Solution {

    private val dp = Array<Array<Int>>(305) {
        Array(305) { -1 }
    }

    fun maxCoins(nums: IntArray): Int {
        return solve(1, nums.lastIndex + 1, nums.toMutableList().apply {
            add(0, 1)
            add(1)
        })
    }

    fun solve(start: Int, end: Int, nums: MutableList<Int>): Int {
        if (start > end)
            return 0

        if (dp[start][end] != -1)
            return dp[start][end]

        var max = Int.MIN_VALUE
        for (index in start..end) {
            val calculate = nums[index] * nums[start - 1] * nums[end + 1]
            val solution = calculate + solve(start, index - 1, nums) + solve(index + 1, end, nums)
            max = maxOf(max, solution)
        }
        return max.also {
            dp[start][end] = it
        }
    }
}

fun main() {
    println(Solution().maxCoins(intArrayOf(8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5, 5)))
    println(Solution().maxCoins(intArrayOf(1, 5)))
    println(Solution().maxCoins(intArrayOf(3, 1, 5, 8)))
}