package com.harera.leetcode.leetcode486

import java.lang.Integer.max

class Solution {

    private val dp = Array(21) { Array(21) { Array(2) { Array(2) { -1 } } } }

    fun predictTheWinner(nums: IntArray): Boolean {
        val solution = solve(nums, pTurn = 1, i = 0, j = nums.lastIndex)
        return solution.first >= solution.second
    }

    private fun solve(nums: IntArray, pTurn: Int, i: Int, j: Int): Pair<Int, Int> {
        if (i >= j) {
            if (nums.size % 2 != 0) {
                if (pTurn == 1)
                    return Pair(max(nums[i], nums[j]), 0)
                else
                    return Pair(0, max(nums[i], nums[j]))
            }
            return Pair(0, 0)
        }

        if (dp[i][j][pTurn][0] != -1) {
            return Pair(dp[i][j][pTurn][0], dp[i][j][pTurn][1])
        }

        val pSum: Int
        val qSum: Int
        if (pTurn == 1) {
            val dp1 = solve(nums, 0, i + 1, j)
            val dp2 = solve(nums, 0, i, j - 1)
            if (nums[i] + dp1.first >= nums[j] + dp2.first) {
                pSum = nums[i] + dp1.first
                qSum = dp1.second
            } else {
                pSum = nums[j] + dp2.first
                qSum = dp2.second
            }
        } else {
            val dp1 = solve(nums, 1, i + 1, j)
            val dp2 = solve(nums, 1, i, j - 1)
            if (nums[i] + dp1.second >= nums[j] + dp2.second) {
                pSum = dp1.first
                qSum = nums[i] + dp1.second
            } else {
                pSum = dp2.first
                qSum = nums[j] + dp2.second
            }
        }

        return Pair(pSum, qSum).also {
            dp[i][j][pTurn][0] = it.first
            dp[i][j][pTurn][1] = it.second
        }
    }
}

fun main() {
    Solution().predictTheWinner(intArrayOf(1, 5, 2)).let {
        println(it)
    }
}